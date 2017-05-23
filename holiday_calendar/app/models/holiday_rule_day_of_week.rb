class HolidayRuleDayOfWeek < HolidayRule

  def holiday?(date)
    self.day_of_month.eql? date.cwday
  end

end
