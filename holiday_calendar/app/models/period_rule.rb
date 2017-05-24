class PeriodRule < HolidayRule
  validates :beginning, :end, presence: true
end