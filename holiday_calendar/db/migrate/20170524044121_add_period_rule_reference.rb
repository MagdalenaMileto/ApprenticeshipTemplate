class AddPeriodRuleReference < ActiveRecord::Migration[5.1]
  def change
    add_reference :holiday_rules, :period_rule, foreign_key: true
  end
end
