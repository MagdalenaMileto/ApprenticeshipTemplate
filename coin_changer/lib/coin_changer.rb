class CoinChanger

  def initialize(coin_denominations)
    @coins = coin_denominations.sort.reverse
  end

  def change(amount)
    remaining = amount
    exchange = Hash.new
    @coins.each do |denomination|
      exchange[denomination] = remaining / denomination
      remaining = remaining % denomination
    end
    exchange.delete_if { |_, value| value.zero? }
  end
end

