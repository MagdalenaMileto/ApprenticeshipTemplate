class CalendarsController < ApplicationController
  def calendars
    @calendars = Calendar.all
    render :json => @calendars
  end

  def find_calendar_by
    puts params
    name = params[:name]
    @calendars = Calendar.all
    var = @calendars.find_by(name: name)
    render :json => var
  end
end
