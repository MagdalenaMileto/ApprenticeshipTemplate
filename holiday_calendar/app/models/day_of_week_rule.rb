class DayOfWeekRule < HolidayRule
  validates :day_of_week, presence: true

  def holiday?(date)
    day_of_week == date.cwday
  end
end
