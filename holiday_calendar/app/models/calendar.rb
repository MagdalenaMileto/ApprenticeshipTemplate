class Calendar < ApplicationRecord
  has_many :holiday_rules

  def add_rule(rule)
    holiday_rules << rule
  end

  def holiday?(date)
    holiday_rules.any? { |rule| rule.holiday?(date) }
  end

  def rules_between(starts, ends)
    Range.new(starts, ends)
    holiday_rules.select do |date|
      holiday?(date)
    end
  end
end

