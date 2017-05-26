class CalendarsController < ApplicationController
  def index
    render json: Calendar.where('? IS NULL OR name LIKE ?', calendar_name, "%#{calendar_name}%")
  end

  def show
    render json: Calendar.find(calendar_id)
  end

  def create
    render json: Calendar.create!(calendar_params)
  end

  def update
    calendar = Calendar.find(calendar_id)
    calendar.update!(calendar_params)
    render json: calendar
  end

  private
  def calendar_name
    params[:name]
  end

  def calendar_id
    params[:id]
  end

  #TODO Revisar?
  def calendar_params
    calendar = params.require(:calendar)
    name = calendar.permit(:name)
    rules = calendar[:holiday_rules] || []
    rules.map! do |rule|
      HolidayRuleSerializer.deserialize(rule)
    end
    name.merge(holiday_rules: rules)
  end
end
