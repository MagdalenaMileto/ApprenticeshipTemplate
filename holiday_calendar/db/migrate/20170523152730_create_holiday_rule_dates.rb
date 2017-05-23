class CreateHolidayRuleDates < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_rule_dates do |t|

      t.timestamps
    end
  end
end
