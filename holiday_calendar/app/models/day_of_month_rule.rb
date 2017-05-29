class DayOfMonthRule < HolidayRule
  validates :day_of_month, :month, presence: true

  def holiday?(date)
    (month == date.month) && (day_of_month == date.day)
  end
end
