class AddHolidayRuleIds < ActiveRecord::Migration[5.1]
  def change
    add_reference :holiday_rules, :holiday_calendar, foreign_key: true
    add_reference :holiday_rules, :holiday_rule, primary_key:true
  end
end
