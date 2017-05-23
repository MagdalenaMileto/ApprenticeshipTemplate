class HolidayRuleDate < HolidayRule
  def holiday?(date)
    holiday_date.eql? date
  end
end
