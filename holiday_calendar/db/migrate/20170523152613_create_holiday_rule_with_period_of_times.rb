class CreateHolidayRuleWithPeriodOfTimes < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_rule_with_period_of_times do |t|

      t.timestamps
    end
  end
end
