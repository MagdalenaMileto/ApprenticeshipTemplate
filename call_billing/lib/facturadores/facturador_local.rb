class FacturadorLocal < Facturador

  def calcular_monto(franja_horaria, duracion)
    franja_horaria.precio_por_minuto * duracion
  end
end