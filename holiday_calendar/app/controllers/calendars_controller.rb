class CalendarsController < ApplicationController
  def index
    render json: Calendar.where('? IS NULL OR name LIKE ?', calendar_name, "%#{calendar_name}%")
  end

  def show
    render json: Calendar.find(calendar_id)
  end

  private
  def calendar_name
    params[:name]
  end

  def calendar_id
    params[:id]
  end
end
