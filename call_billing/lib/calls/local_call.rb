class LocalCall < Call

  def initialize(time_zone, duration)
    @time_zone = time_zone
    @duration = duration
  end

  def total_amount
    super + price_duration
  end

  def price_duration
    @time_zone.price_per_minute * @duration
  end
end