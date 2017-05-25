require 'rails_helper'

RSpec.describe CalendarsController, type: :controller do
  context 'Given a GET request to /calendars withouth saving' do
    it 'returns no calendar' do
      get :index
      expect(response).to have_http_status :ok
      expect(json_response.count).to eq(0)
    end
  end

  context 'Given a GET request to /calendars' do
    it 'returns all calendars' do
      calendar = Calendar.create!(name: 'Argentina')
      get :index
      expect(response).to have_http_status :ok
      expect(json_response[0]['id']).to eq(calendar.id)
      expect(json_response.count).to eq(1)
    end
  end

  context 'Given a GET request to calendars?name=argentina' do
    it 'returns all calendars wich contains that name' do
      Calendar.create!(name: 'Argentina')
      Calendar.create!(name: 'Suiza')
      Calendar.create!(name: 'Argenmexico')
      get :index, params: { name: 'Argen'}
      expect(response).to have_http_status :ok
      expect((json_response).count).to eq(2)
    end
  end

  context 'Given a GET request to calendars/id' do
    it 'returns all calendars with that id' do
      calendar = Calendar.create!(name: 'Argentina')
      get :show, params: {id: calendar.id}
      expect(response).to have_http_status :ok
      expect(json_response).to be(name: 'Argentina', id: 1)
    end
  end

  def json_response
    JSON.parse response.body
  end
end
