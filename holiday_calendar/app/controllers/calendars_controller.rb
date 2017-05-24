class CalendarsController < ApplicationController
  def calendars
    @calendars = Calendar.all
    render :json => @calendars
  end

  def find_calendar_by_name
    puts params
    name = params[:name]
    @calendars = Calendar.all
    var = @calendars.find_by(name: name)
    render :json => var
  end

  def find_calendar_by_id
    puts params
    id = params[:id]
    @calendars = Calendar.all
    render :json => @calendars.find(id: id)
  end
end
