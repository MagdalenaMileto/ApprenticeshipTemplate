describe 'Hands' do

  let(:hand) { Hand.new }
  describe '#valid?' do
    context 'given five cards to a hand' do
      it 'return true' do
        expect(hand.valid?).to be(true)
      end
    end
  end
end