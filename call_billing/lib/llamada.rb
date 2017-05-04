class Llamada
  attr_reader :franja_horaria, :duracion

  def var(franja_horaria, duracion)
    @franja_horaria = franja_horaria
    @duracion = duracion
  end
end