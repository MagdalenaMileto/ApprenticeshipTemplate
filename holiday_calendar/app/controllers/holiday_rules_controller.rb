class HolidayRulesController < ApplicationController

  def index
    calendar = params.require(:calendar)
    starts = Date.parse(params[:starts])
    ends = Date.parse(params[:ends])
    render json: (starts..ends).filter do |date|
      calendar.holiday?(date)
    end
  end

end
