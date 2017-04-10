class CoinChanger

  def initialize(coin_denominations)
    @coins = coin_denominations
  end

  def change_for(amount)
    if @coins.include?(amount)
      {amount => 1}
    elsif amount == 0
      {}
    else
      
    end
  end
end