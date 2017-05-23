class CreateHolidayRuleDayOfMonths < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_rule_day_of_months do |t|

      t.timestamps
    end
  end
end
