class HolidayRuleDayOfWeek < HolidayRule

  def initialize(day_of_week)
    @day_of_month = day_of_week
  end

  def non_workable?(date)
    @day_of_month.eql? date.cwday
  end

end