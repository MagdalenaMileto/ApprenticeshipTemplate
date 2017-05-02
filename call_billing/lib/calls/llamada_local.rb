class LlamadaLocal < Llamada

  def initialize(franja_horaria, duracion)
    @franja_horaria = franja_horaria
    @duracion = duracion
  end

  def monto_total
    super + precio_por_duracion
  end

  def precio_por_duracion
    @franja_horaria.precio_por_minuto * @duracion
  end
end