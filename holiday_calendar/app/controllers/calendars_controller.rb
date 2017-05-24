class CalendarsController < ApplicationController
  def calendars
    @calendars = Calendar.all
    render :json => @calendars
  end

  def search_calendars_by
    puts params
    name = params[:name]
    @calendars = Calendar.all
    var = @calendars.find_by(name: name)
    render :json => var
  end
end
