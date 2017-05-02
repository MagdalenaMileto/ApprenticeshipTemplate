class FacturadorLocal

  def calcular_monto(franja_horaria, duracion)
    precio_base + precio_por_duracion(franja_horaria, duracion)
  end

  def precio_por_duracion(franja_horaria, duracion)
    franja_horaria.precio_por_minuto * duracion
  end
end