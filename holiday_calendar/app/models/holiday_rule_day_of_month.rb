class HolidayRuleDayOfMonth

  def initialize(month2, day_of_month2)
    @month = month2
    @day_of_month = day_of_month2
  end

  def non_workable?(date)
    (@month.eql? date.month) && (@day_of_month.eql? date.day)
  end

end