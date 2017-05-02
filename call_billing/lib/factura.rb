class Factura

  def initialize(mes, llamadas)
    @mes = mes
    @llamadas = llamadas
  end

  def total_amount
    @calls.monto_total()
  end

end