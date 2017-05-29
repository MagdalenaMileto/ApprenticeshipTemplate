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
    calendar = Calendar.find calendar_id
    render json: calendar.add_rule(HolidayRule.create!(rule_params))
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

  def rule_params
    rule = params.require(:rule)
    HolidayRuleSerializer.deserialize(rule)
  end

end