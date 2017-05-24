class DayOfWeekRule < HolidayRule
  validates :day_of_week, presence: true
end