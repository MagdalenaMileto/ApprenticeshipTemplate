class CreateHolidayRule < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_rules do |t|
      t.string :type, null: false
    end
  end
end
