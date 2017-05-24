class AddPeriodRule < ActiveRecord::Migration[5.1]
  def change
    add_column :holiday_rules, :beginning, :date
    add_column :holiday_rules, :end, :date
  end
end
