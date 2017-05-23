class AddHolidayRuleIds < ActiveRecord::Migration[5.1]
  def change
    add_reference :holiday_rules, :holiday_calendar_id, foreign_key: true
  end
end
