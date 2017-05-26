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

  private
  def calendar_name
    params[:name]
  end

  def calendar_id
    params[:id]
  end

  #TODO Preguntar como pasarle reglas
  def calendar_params
    params.require(:calendar).permit(:name)
  end
end
