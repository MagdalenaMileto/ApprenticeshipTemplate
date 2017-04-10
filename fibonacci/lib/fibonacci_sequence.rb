class FibonacciSequence

  def number_for(position)
    raise 'the position must be positive' if position < 0
    raise 'the position must be a Integer' unless position.is_a? Integer
    if position > 1
      number_for(position - 2) + number_for(position - 1)
    else
    position
    end
  end
end