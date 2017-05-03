class Facturador

  def monto_para(llamada)
    @franja_horaria = llamada.franja_horaria
    @duracion = llamada.duracion
    precio_por_duracion(@franja_horaria, @duracion)
  end

end