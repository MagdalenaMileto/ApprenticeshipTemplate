class HolidayRuleDayOfWeek < HolidayRule
  validates :day_of_week, presence: true

  def holiday?(date)
    day_of_week.eql? date.cwday
  end
end
