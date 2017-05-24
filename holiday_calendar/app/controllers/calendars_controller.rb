class CalendarsController < ApplicationController
  def all_calendars
    @calendars = Calendar.all
    render :json => @calendars
  end

  def calendars_by_name
    
  end
end
