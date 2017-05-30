require 'rails_helper'

describe CalendarsController do

  describe '#index' do
    context 'with a query string' do

      context 'without calendars' do
        it 'is successful' do
          get :index, params: {name: 'gent'}
          expect(response).to have_http_status :ok
        end

        it 'returns an empty list' do
          get :index, params: {name: 'gent'}
          expect(json_response).to have(0).calendars
        end
      end

      context 'with calendars' do
        before do
          Calendar.create!(name: 'Argentina')
          Calendar.create!(name: 'Suiza')
          Calendar.create!(name: 'Argentmexico')
        end

        it 'is successful' do
          get :index, {params: {name: 'gent'}}
          expect(response).to have_http_status :ok
        end

        it 'returns a calendar list' do
          get :index, {params: {name: 'gent'}}
          expect(json_response.first).to include_json(id: 1, name: 'Argentina')
          expect(json_response.second).to include_json(id: 3, name: 'Argentmexico')
        end
      end
    end

    context 'without a query string' do

      context 'without calendars' do

        it 'is successful' do
          get :index
          expect(response).to have_http_status :ok
        end

        it 'returns an empty list' do
          get :index
          expect(json_response).to have(0).calendars
        end
      end

      context 'with calendars' do
        before do
          Calendar.create!(name: 'Argentina')
        end

        it 'is successful' do
          get :index
          expect(response).to have_http_status :ok
        end

        it 'returns a calendar list' do
          get :index
          expect(json_response.first).to include_json(id: 1, name: 'Argentina')
        end
      end
    end
  end

  describe '#show' do
    context 'when the id exists' do

      it 'returns a calendar' do
        Calendar.create!(name: 'Argentina')
        get :show, params: {id: 1}
        expect(json_response).to include_json(id: 1, name: 'Argentina')
      end
    end

    context 'when the id is invalid' do
      it 'returns 404 not found' do
        expect { get :show, params: {id: 1} }.to raise_error ActiveRecord::RecordNotFound
      end
    end
  end

  describe '#create' do
    context 'given complete params' do
      it 'return a calendar' do
        post :create, params: {calendar: {name: 'Argentina'}}
        expect(json_response).to include_json(id: 1, name: 'Argentina')
      end

      it 'return a calendar with rules' do
        rules = [{type: 'DayOfWeekRule', day_of_week: 1}]
        post :create, params: {calendar: {name: 'Argentina', holiday_rules: rules}}
        expect(json_response['holiday_rules']).to have(1).rule
      end
    end

    context 'given incomplete params' do
      it 'return an error' do
        expect { post :create }.to raise_error ActionController::ParameterMissing
      end
    end
  end

  describe '#update' do
    context 'when only update the calendar name' do
      it 'is successful' do
        calendar = Calendar.create!(name: 'Argentina', holiday_rules: [])
        put :update, params: { id: calendar.id, calendar: {name: 'Peronia', holiday_rules: []}}
        expect(response).to have_http_status :ok
      end

      it 'returns the calendar with the new name' do
        calendar = Calendar.create!(name: 'Argentina', holiday_rules: [])
        put :update, params: { id: calendar.id, calendar: {name: 'Peronia', holiday_rules: []}}
        expect(json_response).to include_json(id: 1, name: 'Peronia')
      end
    end

    context 'when updates the name and the holiday_rules' do
      it 'returns the calendar completly changes' do
        calendar = Calendar.create!(name: 'Argentina', holiday_rules: [])
        put :update, params: { id: calendar.id, calendar: {name: 'Macrilandia', holiday_rules: [{type: 'DayOfWeekRule', day_of_week: 1}]}}
        expect(json_response['holiday_rules']).to have(1).rule
      end
    end
  end

  describe '#get_holidays' do
    context 'given a calendar with day of week holiday rule' do
      context 'when there is beginning and end'
      it 'returns all the holiday rules between those dates' do
        rule = DayOfWeekRule.create(day_of_week: 1)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :get_holidays, {params: {id: '1', begins: '2017-1-1', ends: '2017-1-14'}}

        expect(json_response).to eq ['2017-01-02', '2017-01-09']
      end
    end

    context 'when there isnt beginning or end' do
      it 'returns all the holiday rules between that year' do
        rule = DayOfMonthRule.create(day_of_month: 25, month: 2)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :get_holidays, {params: {id: '1'}}

        expect(json_response).to eq ['2017-02-25']
      end
    end

    context 'when there isnt beginning' do
      it 'returns all the holiday rules between that year' do
        rule = DayOfMonthRule.create(day_of_month: 25, month: 2)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :get_holidays, {params: {id: '1', begins: '2016-1-1'}}

        expect(json_response).to eq ['2017-02-25']
      end
    end

    context 'when there isnt end' do
      it 'returns all the holiday rules between that year' do
        rule = DayOfMonthRule.create(day_of_month: 25, month: 2)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :get_holidays, {params: {id: '1', ends: '2017-1-14'}}

        expect(json_response).to eq ['2017-02-25']
      end
    end
  end

  describe '#add_new_rule' do
    it 'return a new rule' do
      calendar = Calendar.create!(name: 'Argentina', holiday_rules: [])
      post :add_new_rule, {params: {id: calendar.id, type: 'DayOfMonthRule', day_of_month: 25, month: 2}}

      expect(json_response['holiday_rules']).to have(1).rule
    end
  end

  def json_response
    JSON.parse response.body
  end
end