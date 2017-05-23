class AddHolidayRuleDayOfMonth < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :month, :integer
    add_column :holiday_rules, :day_of_month, :integer
  end
end
