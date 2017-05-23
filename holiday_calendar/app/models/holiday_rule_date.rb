class HolidayRuleDate < HolidayRule

  def initialize(date)
    @non_workable_date = date
  end

  def non_workable?(date)
    @non_workable_date.eql? date
  end

end