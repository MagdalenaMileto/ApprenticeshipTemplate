require 'rspec'

describe TimeZone do
  let(:time_zone_rush_hour) { TimeZone.new(0.20) }
  describe '#price_per_minute' do
    it 'returns 0.20' do
      expect(time_zone_rush_hour.price_per_minute).to eq(0.20)
    end
  end

  let(:time_zone_normal_hour) { TimeZone.new(0.10) }
  describe '#price_per_minute' do
    it 'returns 0.10' do
      expect(time_zone_normal_hour.price_per_minute).to eq(0.10)
    end
  end
end