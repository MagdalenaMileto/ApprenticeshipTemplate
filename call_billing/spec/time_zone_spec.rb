require 'rspec'

describe TimeZone do
  let(:time_zone_rush_hour) { TimeZone.new(0.20) }
  describe '#price_per_minute' do
    it 'returns the price' do
      expect(time_zone_rush_hour.price_per_minute).to eq(0.20)
    end
  end
end