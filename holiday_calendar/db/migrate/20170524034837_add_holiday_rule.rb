class AddHolidayRule < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :date, :date
  end
end
