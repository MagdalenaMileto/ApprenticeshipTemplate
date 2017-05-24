class AddCalendarName < ActiveRecord::Migration[5.1]
  def change
    add_column :calendars, :name, :string
  end
end
