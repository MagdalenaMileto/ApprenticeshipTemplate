class DateRule < HolidayRule
  validates :date, presence: true

  def holiday?(date)
    self.date == date
  end
end
