class AddCalendarName < ActiveRecord::Migration[5.1]
  def change
    add_column :calendar, :name, :string
  end
end
