require 'rails_helper'

describe HolidayRulesController, type: :controller do

  describe '#index' do
    context 'given a calendar with holiday rules' do
      it 'returns all the holiday rules' do
        rule = DayOfWeekRule.create(day_of_week: 1)
        Calendar.create!(name: 'Argentina', holiday_rules: [rule])
        get :index, params: {beggins: '1992-1-1', ends: '2017,1,1'}

        expect(json_response).to include_json(holiday_rules: [{type: 'DayOfWeekRule', day_of_week: 1}])
      end
    end
  end
end