require 'rails_helper'

RSpec.describe CalendarsController, type: :controller do
  context 'Given a GET request to /calendarios withouth saving' do
    it 'returns no calendar' do
      get :all_calendars
      expect(response).to have_http_status :ok
      expect((JSON.parse response.body).count).to be(0)
    end
  end

  context 'Given a GET request to /calendarios' do
    it 'returns all calendars' do
      calendar = Calendar.create!(name: 'Argentina')
      get :all_calendars
      expect(response).to have_http_status :ok
      expect((JSON.parse response.body)[0]['id']).to be(calendar.id)
      expect((JSON.parse response.body).count).to be(1)
    end
  end
end
