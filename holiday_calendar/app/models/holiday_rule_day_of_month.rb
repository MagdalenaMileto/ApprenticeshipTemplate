class HolidayRuleDayOfMonth < ApplicationRecord

  def non_workable?(date)
    (self.month.eql? date.month) && (self.day_of_month.eql? date.day)
  end

end
