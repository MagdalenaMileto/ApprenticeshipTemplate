class DayOfMonthRule < HolidayRule
  validates :day_of_month, :month, presence: true

  def holiday?(date)
    (month == date.month) && (day_of_month == date.day)
  end

  def self.from_json(rule)
    DayOfMonthRule.new(rule.permit(:day_of_month, :month))
  end
end
