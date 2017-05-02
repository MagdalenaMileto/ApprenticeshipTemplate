require 'rspec'

describe LocalCall do

  let(:time_zone_rush_hour) { TimeZone.new(0.20) }
  let(:local_call) { LocalCall.new(time_zone_rush_hour, 5) }
  describe '#price_duration' do
    it 'returns price * duration' do
      expect(local_call.price_duration).to eq(1)
    end
  end
end