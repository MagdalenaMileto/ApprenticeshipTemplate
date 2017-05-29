class HolidayRulesController < ApplicationController

  def index
    calendar = Calendar.find calendar_id
    if (starts.nil? || ends.nil?)
      starts = starts_actual_year
      ends = ends_actual_year
    else
      Date.strptime(starts, '%d/%m/%Y')
      Date.strptime(ends, '%d/%m/%Y ')
      render json: calendar.rules_between(starts, ends)
    end
  end

  private
  def calendar_id
    params[:id]
  end

  def starts
    starts = Date.parse(params[:starts])
  end

  def ends
    ends = Date.parse(params[:ends])
  end

  def starts_actual_year
    Date.new(Date.today.year, 1, 1)
  end

  def ends_actual_year
    Date.new(Date.today.year, 12, 31)
  end

end