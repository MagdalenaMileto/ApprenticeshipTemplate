class Bill

  def initialize(month, calls)
    @month = month
    @calls = calls
  end

  def total_amount
    @calls.total_amount()
  end

end