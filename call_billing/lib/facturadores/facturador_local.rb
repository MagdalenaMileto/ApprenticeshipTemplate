class FacturadorLocal

  def monto_para(llamada)
    franja_horaria = llamada.franja_horaria
    duracion = llamada.duracion
    precio_por_duracion(franja_horaria, duracion)
  end

  def precio_por_duracion(franja_horaria, duracion)
    franja_horaria.precio_por_minuto * duracion
  end
end