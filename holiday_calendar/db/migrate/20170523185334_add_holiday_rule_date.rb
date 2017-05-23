class AddHolidayRuleDate < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :holiday_date, :date
  end
end
