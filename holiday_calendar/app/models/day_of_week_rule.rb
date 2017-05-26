class DayOfWeekRule < HolidayRule
  validates :day_of_week, presence: true

  def holiday?(date)
    day_of_week == date.cwday
  end

  def between?(_date)
    true
  end

  def self.from_json(rule)
    DayOfWeekRule.new(rule.permit(:day_of_week))
  end
end
