class HolidayRuleWithPeriodOfTime

  def initialize(week_rule, period)
    @week_rule = week_rule
    @period = period
  end

  def non_workable?(date)
    (@week_rule.non_workable? date) && (@period.include? date)
  end

end