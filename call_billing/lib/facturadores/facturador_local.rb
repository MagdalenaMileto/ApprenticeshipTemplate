class FacturadorLocal < Facturador

  def precio_por_duracion(franja_horaria, duracion)
    franja_horaria.precio_por_minuto * duracion
  end
end