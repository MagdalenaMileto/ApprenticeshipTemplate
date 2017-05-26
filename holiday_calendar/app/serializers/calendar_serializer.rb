class CalendarSerializer < ActiveModel::Serializer
  attributes :id, :name
  has_many :holiday_rules
end
