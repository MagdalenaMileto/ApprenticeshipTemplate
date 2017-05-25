class AddCalendarIdHolidayRules < ActiveRecord::Migration[5.1]
  def change
    add_reference :holiday_rules, :calendar, index: true
    add_foreign_key :holiday_rules, :index
  end
end
