class FacturadorNacional < Facturador

  def precio_por_duracion(_franja_horaria, duracion)
    duracion * 0.30
  end

end