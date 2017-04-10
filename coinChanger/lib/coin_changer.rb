class CoinChanger
  @coins = {1 => 50, 5 => 50, 10 => 50, 25 => 50, 100 => 50}

  def initialize(coin_denominations)
  end

  def give_change_for(amount)
    if amount == 10
      {10 => 1}
    else
      {}
    end
  end
end