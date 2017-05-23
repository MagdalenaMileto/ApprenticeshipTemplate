class HolidayRuleDate < ApplicationRecord

  def non_workable?(date)
    self.non_workable_date.eql? date
  end

end
