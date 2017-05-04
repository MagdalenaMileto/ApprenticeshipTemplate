class Facturador

  def monto_para(llamada)
    @franja_horaria = llamada.franja_horaria
    @duracion = llamada.duracion
    @telefono_llamador = llamada.telefono_llamador
    @telefono_receptor = llamada.telefono_receptor
    calcular_monto(@franja_horaria, @duracion, @telefono_llamador, @telefono_receptor)
  end

end