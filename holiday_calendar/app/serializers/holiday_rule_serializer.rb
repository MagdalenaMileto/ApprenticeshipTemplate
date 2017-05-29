class HolidayRuleSerializer < ActiveModel::Serializer
  attributes :id, :type

  def self.deserialize(rule)
    case rule[:type]
      when 'DayOfWeekRule'
        DayOfWeekRule.new(rule.permit(:day_of_week))
      when 'DayOfMonthRule'
        DayOfMonthRule.new(rule.permit(:day_of_month, :month))
      when 'DateRule'
        DateRule.new(rule.permit(:date))
      when 'PeriodRule'
        PeriodRule.new(rule.permit(:holiday_rule, :beginning, :end))
    end
  end


end
