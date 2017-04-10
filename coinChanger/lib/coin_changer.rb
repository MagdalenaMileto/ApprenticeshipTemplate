class CoinChanger

  def initialize(coin_denominations)
    @coins = coin_denominations.sort.reverse
  end

  def change_for(amount)
    if @coins.include?(amount)
      {amount => 1}
    elsif amount == 0
      {}
    else
      if @coins.include?(amount - 1)
        {amount - 1 => 1, 1 => 1}
      else
        if @coins.include?(amount - 5)
          {amount - 5 => 1, 5 => 1}
        else
          raise 'no denomination'
        end
      end
    end
  end
end
