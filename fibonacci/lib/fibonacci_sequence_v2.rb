class FibonacciSequenceV2
  def initialize
    @values = Array.new
    @values[0] = 0
    @values[1] = 1
  end

  def number_for(position)
    raise 'the position must be positive' if position < 0
    raise 'the position must be a Integer' unless position.is_a? Integer
    @values[position] || new_value(position)
  end

  def new_value(position)
    result = number_for(position - 2) + number_for(position - 1)
    @values[position] = result
    result
  end
end