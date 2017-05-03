class Factura

  def initialize(mes, llamadas, o_facturador)
    @mes = mes
    @llamadas = llamadas
    @facturador = o_facturador
  end

  def monto_total
    monto_base + gastos_llamadas
  end

  def gastos_llamadas
    @llamadas.sum { |llamada| @facturador.monto_para(llamada)} || 0
  end

  def monto_base
    10
  end

end