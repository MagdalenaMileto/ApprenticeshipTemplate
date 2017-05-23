class CreateHolidayCalendars < ActiveRecord::Migration[5.1]
  def change
    create_table :holiday_calendars do |t|

      t.timestamps
    end
  end
end
