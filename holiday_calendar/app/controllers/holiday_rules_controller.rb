class HolidayRulesController < ApplicationController

  def index
    calendar = Calendar.find calendar_id
    if (begins.nil? || ends.nil?)
      begins = Date.new(Date.today.year, 1, 1)
      ends = Date.new(Date.today.year, 12, 31)
    else
      begins = Date.parse(begins())
      ends = Date.parse(ends())
    end
      render json: calendar.holidays_between(begins, ends)
  end

  def create
    
  end

  private
  def calendar_id
    params[:id]
  end

  def begins
    params[:begins]
  end

  def ends
    params[:ends]
  end
end