class HolidayCalendar < ApplicationRecord

  def holiday?(date)
    holiday_rule.any? { |rule| rule.holiday? date }
  end

  def add_rule(rule)
    holiday_rule << rule
  end
end
