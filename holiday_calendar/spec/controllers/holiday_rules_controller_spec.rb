require 'rails_helper'

describe HolidayRulesController, type: :controller do

  describe '#index' do
    context 'given a calendar with day of week holiday rule' do
      context 'when there is beginning and end'
      it 'returns all the holiday rules between those dates' do
        rule = DayOfWeekRule.create(day_of_week: 1)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :index, {params: {id: '1', begins: '2017-1-1', ends: '2017-1-14'}}

        expect(json_response).to eq ['2017-01-02', '2017-01-09']
      end
    end

    context 'when there isnt beginning or end' do
      it 'returns all the holiday rules between that year' do
        rule = DayOfMonthRule.create(day_of_month: 25, month: 2)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :index, {params: {id: '1'}}

        expect(json_response).to eq ['2017-02-25']
      end
    end

    context 'when there isnt beginning' do
      it 'returns all the holiday rules between that year' do
        rule = DayOfMonthRule.create(day_of_month: 25, month: 2)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :index, {params: {id: '1', begins: '2016-1-1'}}

        expect(json_response).to eq ['2017-02-25']
      end
    end

    context 'when there isnt end' do
      it 'returns all the holiday rules between that year' do
        rule = DayOfMonthRule.create(day_of_month: 25, month: 2)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :index, {params: {id: '1', ends: '2017-1-14'}}

        expect(json_response).to eq ['2017-02-25']
      end
    end
  end

  def json_response
    JSON.parse response.body
  end
end
