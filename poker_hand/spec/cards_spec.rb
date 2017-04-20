describe 'PokerCard' do

  let(:poker_card_1) { PokerCard.new(PokerCard.values('As'), :C) }
  let(:invalid_card) { PokerCard.new(PokerCard.values(-3), :C) }

  describe '#valid?' do
    context 'given a valid card' do
      it 'return true' do
        expect(poker_card_1.valid?).to be(true)
      end
    end
  end

  describe '#valid?' do
    context 'given a invalid card' do
      it 'raise a exception' do
        expect { (invalid_card.valid?) }.to raise_error('Invalid card value')
      end
    end
  end
end

describe 'CardComparator' do

  let(:card_comparator) { CardComparator.new }
  let(:poker_card_1) { PokerCard.new(PokerCard.values('As'), :C) }
  let(:poker_card_2) { PokerCard.new(PokerCard.values(4), :C) }

  describe '#bigger_card' do
    context 'given two cards' do
      it 'return the most valuable one' do
        expect(card_comparator.bigger_card(poker_card_1, poker_card_2)).to eq(poker_card_1)
      end
    end
  end
end