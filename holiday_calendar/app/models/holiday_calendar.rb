class HolidayCalendar < ApplicationRecord

  def non_workable?(date)
    self.non_workable_day_rule.any? { |rule| rule.non_workable? date }
  end

  def add_rule(rule)
    self.non_workable_day_rule << rule
  end
end
