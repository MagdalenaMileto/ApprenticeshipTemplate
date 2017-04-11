describe CoinChanger do
  describe '#change' do
    let(:coin_changer) { CoinChanger.new([1, 5, 10, 25, 50, 100]) }

    context 'given 0' do
      it 'return 0' do
        expected_change = {}
        expect(coin_changer.change(0)).to eq(expected_change)
      end
    end

    context 'given a exact coin denomination' do
      it 'should return that coin' do
        expected_change = {10 => 1}
        expect(coin_changer.change(10)).to eq(expected_change)
      end
    end

    context 'given a number that satisfy various coins' do
      it 'return ' do
        expected_change = {100 => 1, 50 => 1, 25 => 1, 1 => 2}
        expect(coin_changer.change(177)).to eq(expected_change)
      end
    end

    context 'given a negative number' do
      it 'return an exception' do
        expect{coin_changer.change(-3).to raise_error('Invalid amount of money, it should be
        a positive entire')}
      end
    end

    context 'given a negative number' do
      it 'return an exception' do
        expect{coin_changer.change(3.4).to raise_error('Invalid amount of money, it should be
        a positive entire')}
      end
    end
  end
end
