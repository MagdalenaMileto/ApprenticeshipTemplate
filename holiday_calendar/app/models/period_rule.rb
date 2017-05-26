class PeriodRule < HolidayRule
  has_one :holiday_rule
  validates :beginning, :end, presence: true

  def holiday?(a_date)
    holiday_rule.holiday?(a_date) && period.include?(a_date)
  end

  def period
    Range.new(beginning, self.end)
  end

  def self.from_json(rule)
    PeriodRule.new(rule.permit(:holiday_rule, :beginning, :end))
  end
end
