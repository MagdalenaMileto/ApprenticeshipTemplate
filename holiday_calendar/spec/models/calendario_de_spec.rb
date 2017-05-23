require 'spec_helper'
require 'rails_helper'

describe 'Calendario de Feriados' do

  let(:holiday_calendar) { HolidayCalendar.new }

  it 'test01: un dia de semana puede ser feriado' do
    un_sabado = Date.new(2017, 4, 29)
    holiday_calendar.add_rule(HolidayRuleDayOfWeek.new(un_sabado.cwday))
    expect(holiday_calendar.holiday? un_sabado).to be_truthy
  end

  it 'test02: un dia de semana puede NO ser feriado' do
    un_miercoles = Date.new(2017, 5, 3)
    expect(holiday_calendar.holiday? un_miercoles).to be_falsey
  end

  it 'test03: mas de un dia de semana puede ser feriado' do
    un_sabado = Date.new(2017, 5, 6)
    un_domingo = Date.new(2017, 5, 7)
    holiday_calendar.add_rule(HolidayRuleDayOfWeek.new(un_sabado.cwday))
    holiday_calendar.add_rule(HolidayRuleDayOfWeek.new(un_domingo.cwday))
    expect(holiday_calendar.holiday? un_sabado).to be_truthy
    expect(holiday_calendar.holiday? un_domingo).to be_truthy
  end

  it 'test04: un dia de mes puede ser feriado' do
    un_primero_de_mayo = Date.new(2017, 5, 1)
    holiday_calendar.add_rule(HolidayRuleDayOfMonth.new())
    #TODO
    expect(holiday_calendar.holiday? un_primero_de_mayo).to be_truthy
  end

  it 'test05: mas de un dia de mes puede ser feriado' do
    un_primero_de_mayo = Date.new(2017, 5, 1)
    un_25_de_mayo = Date.new(2017, 5, 25)
    holiday_calendar.add_rule(HolidayRuleDayOfMonth.new(5, 1))
    holiday_calendar.add_rule(HolidayRuleDayOfMonth.new(5, 25))
    expect(holiday_calendar.holiday? un_primero_de_mayo).to be_truthy
    expect(holiday_calendar.holiday? un_25_de_mayo).to be_truthy
  end

  it 'test06: un dia de mes puede NO ser feriado' do
    un_primero_de_mayo = Date.new(2017, 5, 1)
    expect(holiday_calendar.holiday? un_primero_de_mayo).to be_falsey
  end

  it 'test07: una fecha puede ser feriado' do
    cumpleaños_de_eze = Date.new(2017, 10, 16)
    holiday_calendar.add_rule(HolidayRuleDate.new(cumpleaños_de_eze))
    expect(holiday_calendar.holiday? cumpleaños_de_eze).to be_truthy
  end

  it 'test08: mas de una fecha puede ser feriado' do
    cumpleaños_de_eze = Date.new(2017, 10, 16)
    cumpleaños_de_feche = Date.new(2017, 12, 22)
    holiday_calendar.add_rule(HolidayRuleDate.new(cumpleaños_de_eze))
    holiday_calendar.add_rule(HolidayRuleDate.new(cumpleaños_de_feche))
    expect(holiday_calendar.holiday? cumpleaños_de_eze).to be_truthy
    expect(holiday_calendar.holiday? cumpleaños_de_feche).to be_truthy
  end

  it 'test09: una fecha puede NO ser feriado' do
    cumpleaños_de_eze = Date.new(2017, 10, 16)
    expect(holiday_calendar.holiday? cumpleaños_de_eze).to be_falsey
  end

  it 'test10: un dia de la semana puede ser feriado en un periodo de tiempo' do
    un_sabado = Date.new(2017, 4, 29)
    inicio = Date.new(2015, 10, 12)
    fin = Date.new(2019, 10, 12)
    periodo = Range.new(inicio, fin)
    holiday_calendar.add_rule(HolidayRuleWithPeriodOfTime.new(
        HolidayRuleDayOfWeek.new(un_sabado.cwday), periodo))
    expect(holiday_calendar.holiday? un_sabado).to be_truthy
  end

  it 'test11: un dia de la semana feriado en un periodo puede ser NO feriado fuera de ese periodo de tiempo' do
    un_sabado_fuera_del_periodo = Date.new(2014, 5, 10)
    inicio = Date.new(2015, 10, 12)
    fin = Date.new(2019, 10, 12)
    periodo = Range.new(inicio, fin)
    holiday_calendar.add_rule(HolidayRuleWithPeriodOfTime.new(
        HolidayRuleDayOfWeek.new(un_sabado_fuera_del_periodo.cwday), periodo))
    expect(holiday_calendar.holiday? un_sabado_fuera_del_periodo).to be_falsey
  end

  it 'test12: un dia de mes puede ser feriado en un periodo de tiempo' do
    cumpleaños_de_eze = Date.new(2017, 10, 16)
    inicio = Date.new(2015, 10, 12)
    fin = Date.new(2019, 10, 12)
    periodo = Range.new(inicio, fin)
    holiday_calendar.add_rule(HolidayRuleWithPeriodOfTime.new(
        HolidayRuleDayOfMonth.new(10, 16), periodo))
    expect(holiday_calendar.holiday? cumpleaños_de_eze).to be_truthy
  end

  it 'test13: un dia de mes feriado en un periodo puede ser NO feriado fuera de ese periodo de tiempo' do
    un_cumpleaños_de_eze_fuera_del_periodo = Date.new(2014, 10, 16)
    inicio = Date.new(2015, 10, 12)
    fin = Date.new(2019, 10, 12)
    periodo = Range.new(inicio, fin)
    holiday_calendar.add_rule(HolidayRuleWithPeriodOfTime.new(
        HolidayRuleDayOfMonth.new(10, 16), periodo))
    expect(holiday_calendar.holiday? un_cumpleaños_de_eze_fuera_del_periodo).to be_falsey
  end

end