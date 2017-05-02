class Factura

  def initialize(mes, llamadas)
    @mes = mes
    @llamadas = llamadas
  end

  def monto_total
    monto_base + gastos_llamadas
  end

  def gastos_llamadas
    @llamadas.each { |llamadas| llamadas.monto}
  end

  def monto_base
    10
  end

end