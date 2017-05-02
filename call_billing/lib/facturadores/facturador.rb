class Facturador

  attr_reader precio_base

  def initialize
    @precio_base = 10
  end

  def calcular_monto(_llamada)
    precio_base
  end

end