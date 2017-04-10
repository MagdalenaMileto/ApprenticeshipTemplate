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

  context 'When the amount is one more than any denomination' do
    it 'should return one coin of 1 and one of the denomination - 1' do
      expected_change = {1 => 1, 5 => 1}
      expect(coin_changer.change_for(6)).to eq(expected_change)
    end
  end

  context 'When the amount is 30' do
    it 'should return one of 5 and one of 25' do
      expected_change = {25 => 1, 5 => 1}
      expect(coin_changer.change_for(30)).to eq(expected_change)
    end
  end
end