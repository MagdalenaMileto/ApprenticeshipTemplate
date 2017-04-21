class Hand

  attr_reader :cards

  def initialize(cards)
    @cards = cards
  end

  def valid?
    raise 'Invalid number of cards, they must be 5' if cards.size != 5
    true
  end
end