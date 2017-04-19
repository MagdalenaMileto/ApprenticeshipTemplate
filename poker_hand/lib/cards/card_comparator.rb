class CardComparator

  def bigger_card(card1, card2)
    if (card1.value > card2.value)
      return card1
    else
      card2
    end
  end

end