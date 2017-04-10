describe CoinCalculator do
  let(:calculator) {CoinCalculator.new}
  context 'When coin changer request change for 0' do
    it 'should return 0' do
      expect(calculator.calculate_coins_for(0)).to eq(0)
    end
  end
end