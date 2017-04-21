describe 'Hands' do

  let(:card1) { PokerCard.new(PokerCard.values('1'), :C) }
  let(:card2) { PokerCard.new(PokerCard.values('2'), :C) }
  let(:card3) { PokerCard.new(PokerCard.values('3'), :C) }
  let(:card4) { PokerCard.new(PokerCard.values('4'), :C) }
  let(:card5) { PokerCard.new(PokerCard.values('As'), :C) }
  let(:hand1) { Hand.new([card1, card2, card3, card4, card5]) }
  let(:hand2) { Hand.new([card1, card2, card3, card4, card4]) }

  describe '#valid?' do
    context 'given five cards to a hand' do
      it 'return true' do
        expect(hand1.valid?).to be(true)
      end
    end
  end

  describe '#valid?' do
    let(:invalid_hand) { Hand.new([card1, card2, card3, card4]) }
    context 'given five cards to a hand' do
      it 'return true' do
        expect { (invalid_hand.valid?) }.to raise_error('Invalid number of cards, they must be 5')
      end
    end
  end

  describe '#who_wins' do
    let(:high_card_play) { HighCardPlay.new }
    context 'given two hands to make high value play' do
      it 'return the highest' do
        expect(high_card_play.who_wins(hand1, hand2)).to be(hand1)
      end
    end
  end
end