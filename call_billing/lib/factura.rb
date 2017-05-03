class Factura

  def initialize(mes, o_facturador)
    @mes = mes
    @llamadas = []
    @facturador = o_facturador
  end

  def monto_total
    @llamadas.inject(10) { |sum, llamada| sum + @facturador.monto_para(llamada)}
  end

  def agregar_llamada(llamada)
    @llamadas << llamada
  end

end