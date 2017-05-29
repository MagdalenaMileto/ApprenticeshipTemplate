class HolidayRuleSerializer < ActiveModel::Serializer
  attributes :id, :type

  def self.deserialize(rule)
    case rule[:type]
      when 'DayOfWeekRule'
        DayOfWeekRule.from_json(rule)
      when 'DayOfMonthRule'
        DayOfMonthRule.from_json(rule)
      when 'DateRule'
        DateRule.from_json(rule)
      when 'PeriodRule'
        PeriodRule.from_json(rule)
    end
  end


end
