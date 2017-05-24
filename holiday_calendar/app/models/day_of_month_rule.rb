class DayOfMonthRule < HolidayRule
  validates :day_of_month, :month, presence: true
end
