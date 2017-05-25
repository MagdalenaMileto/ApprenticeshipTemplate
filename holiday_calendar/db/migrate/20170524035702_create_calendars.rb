class CreateCalendars < ActiveRecord::Migration[5.1]
  def change
    create_table :index do |t|

      t.timestamps
    end
  end
end
