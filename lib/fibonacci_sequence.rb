class FibonacciSequence

  def number_for(position)
    if position > 1
      number_for(position - 2) + number_for(position - 1)
    else
    position
    end
  end
end