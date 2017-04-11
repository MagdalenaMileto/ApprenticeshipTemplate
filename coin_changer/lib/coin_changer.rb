class CoinChanger

  def initialize(coin_denominations)
    @coins = coin_denominations.sort.reverse
  end


  def change(amount)
    valid?(amount)

    remaining = amount
    exchange = Hash.new

    @coins.each do |denomination|
      exchange[denomination] = remaining / denomination
      remaining = remaining % denomination
    end
    exchange.delete_if { |_, value| value.zero? }
  end


  def valid?(amount)
    raise 'Invalid amount of money, it should be a positive entire' if amount < 0
    raise 'Invalid amount of money, it should be a positive entire' unless amount.is_a? Integer
  end
end


