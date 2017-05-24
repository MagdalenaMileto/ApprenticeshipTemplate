class DateRule < HolidayRule
  validates :date, presence: true
end