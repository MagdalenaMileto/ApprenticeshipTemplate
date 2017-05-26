class HolidayRulesController < ApplicationController

  def index
    calendar = params.require(:calendar)
    starts = params[:starts]
    ends = params[:ends]
    render json: (starts..ends).filter do |date|
      calendar.holiday?(date)
    end
  end

end
