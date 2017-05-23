class HolidayCalendar < ApplicationRecord

  def holiday?(date)
    self.non_workable_day_rule.any? { |rule| rule.holiday? date }
  end

  def add_rule(rule)
    self.non_workable_day_rule << rule
  end
end
