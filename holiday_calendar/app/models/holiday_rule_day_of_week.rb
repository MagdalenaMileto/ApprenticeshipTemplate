class HolidayRuleDayOfWeek < HolidayRule

  def non_workable?(date)
    self.day_of_month.eql? date.cwday
  end

end
