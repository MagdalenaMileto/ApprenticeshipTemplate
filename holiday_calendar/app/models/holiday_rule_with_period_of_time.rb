class HolidayRuleWithPeriodOfTime < HolidayRule

  def holiday?(date)
    day_of_month.eql? date.cwday
  end

end
