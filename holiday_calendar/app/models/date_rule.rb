class DateRule < HolidayRule
  validates :date, presence: true

  def holiday?(date)
    self.date == date
  end

  def self.from_json(rule)
    DateRule.new(rule.permit(:date))
  end
end
