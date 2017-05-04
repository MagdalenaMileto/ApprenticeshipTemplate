class FacturadorNacional < Facturador

  def calcular_monto(_franja_horaria, duracion)
    duracion * 0.30
  end

end