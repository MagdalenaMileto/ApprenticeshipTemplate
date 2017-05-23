class HolidayRuleDayOfMonth < HolidayRule

  validates :day_of_month, :day, presence: true

  def holiday?(date)
    (month.eql? date.month) && (self.day_of_month.eql? date.day)
  end

end
