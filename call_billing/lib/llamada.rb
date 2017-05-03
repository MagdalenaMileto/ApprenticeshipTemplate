class Llamada
  attr_reader :franja_horaria, :duracion

  def var(tipo_facturador_llamada, franja_horaria, duracion, pais_origen, pais_destino)
    @tipo_facturador_llamada = tipo_facturador_llamada
    @franja_horaria = franja_horaria
    @duracion = duracion
    @pais_origen = pais_origen
    @pais_destino = pais_destino
  end
end