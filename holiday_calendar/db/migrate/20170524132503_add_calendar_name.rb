class AddCalendarName < ActiveRecord::Migration[5.1]
  def change
    add_column :index, :name, :string
  end
end
