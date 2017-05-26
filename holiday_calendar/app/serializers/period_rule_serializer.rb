class PeriodRuleSerializer < HolidayRuleSerializer
  attributes :beginning, :end
  has_one :holiday_rule
end
