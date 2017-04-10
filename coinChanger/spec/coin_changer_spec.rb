describe CoinChanger do
  let(:coin_changer) { CoinChanger.new([1, 5, 10, 25, 100]) }
  context 'Given an exact amount of money' do
    it 'should return 0' do
      expected_change = {}
      expect(coin_changer.give_change_for(0)).to eq(expected_change)
    end
  end

  context 'When the change is 10 cents' do
    it 'should return 1 coin of 10' do
      expected_change = {10 => 1}
      expect(coin_changer.give_change_for(10)).to eq(expected_change)
    end
  end

  context 'When the change is 20 cents' do
    it 'should return 2 coins of 10' do
      expected_change = {10 => 2}
      expect(coin_changer.give_change_for(20).to eq(expected_change))
    end
  end
end