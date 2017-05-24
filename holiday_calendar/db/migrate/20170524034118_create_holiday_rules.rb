class CreateHolidayRules < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_rules do |t|
      t.integer :day_of_week
      t.integer :day_of_month
      t.integer :month
      t.string :type

      t.timestamps
    end
  end
end
