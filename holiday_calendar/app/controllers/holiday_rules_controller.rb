class HolidayRulesController < ApplicationController

  def index
    calendar = find(calendar_id)
    render json: (starts..ends).filter do |date|
      calendar.holiday?(date)
    end
  end

  private
  def calendar_id
    params[:id]
  end

  def starts
    Date.parse(params[:starts])
  end

  def ends
    Date.parse(params[:ends])
  end
end
