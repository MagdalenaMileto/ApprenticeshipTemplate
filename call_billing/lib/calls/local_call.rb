class LocalCall < Call

  def total_amount
    super + 1
  end
end