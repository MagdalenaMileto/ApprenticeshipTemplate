describe CoinChanger do
  let(:coin_changer) { CoinChanger.new([1, 5, 10, 25, 100]) }
  context 'When the change is 0' do
    it 'should return 0' do
      expected_change = {}
      expect(coin_changer.change_for(0)).to eq(expected_change)
    end
  end

  context 'When the change is equals to one coin' do
    it 'should return that coin' do
      expected_change = {10 => 1}
      expect(coin_changer.change_for(10)).to eq(expected_change)
    end
  end

  context 'When the change needs more than one coin' do
    it 'should return xs number of coins' do
      expected_change = {10 => 2}
      expect(coin_changer.change_for(20)).to eq(expected_change)
    end
  end
end