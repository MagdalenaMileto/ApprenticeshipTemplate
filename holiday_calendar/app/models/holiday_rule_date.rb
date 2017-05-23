class HolidayRuleDate < HolidayRule

  def holiday?(date)
    self.non_workable_date.eql? date
  end

end
