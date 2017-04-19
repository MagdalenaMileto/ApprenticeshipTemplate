describe 'PokerCard' do

  let(:card_comparator) { CardComparator.new }
  let(:poker_card_1) { PokerCard.new(PokerCard.values('As'), :C) }
  let(:poker_card_2) { PokerCard.new(PokerCard.values(4), :C) }

  describe '#valid_card' do
    context 'given a card' do
      it 'return true' do
        expect(poker_card_1.valid?).to be(true)
      end
    end
  end
  describe '#bigger_card' do
    context 'given two cards' do
      it 'return the most valuable one' do
        expect(card_comparator.bigger_card(poker_card_1, poker_card_2)).to eq(poker_card_1)
      end
    end
  end
end