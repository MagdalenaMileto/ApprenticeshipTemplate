
class HolidayCalendar

  @non_workable_day_rule

  def initialize
    @non_workable_day_rule = []
  end

  def non_workable?(date)
    @non_workable_day_rule.any? { |rule| rule.non_workable? date }
  end

  def add_rule(rule)
    @non_workable_day_rule << rule
  end
end