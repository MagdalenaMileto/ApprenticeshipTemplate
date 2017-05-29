class HolidayRulesController < ApplicationController

  def index
    calendar = Calendar.find calendar_id
    if (begins.nil? || ends.nil?)
      begins = Date.parse(Date.new(Date.today.year, 1, 1))
      ends = Date.parse(Date.new(Date.today.year, 12, 31))
    else
      begins = begins()
      ends = ends()
    end
      render json: calendar.holidays_between(begins, ends)
  end

  private
  def calendar_id
    params[:id]
  end

  def begins
    Date.parse(params[:begins])
  end

  def ends
    Date.parse(params[:ends])
  end
end