class HolidayRuleDayOfMonth < HolidayRule

  def holiday?(date)
    (self.month.eql? date.month) && (self.day_of_month.eql? date.day)
  end

end
