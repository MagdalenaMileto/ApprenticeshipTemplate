class Llamada
  attr_reader :franja_horaria, :duracion, :telefono_llamador, :telefono_receptor

  def initialize(franja_horaria, duracion, telefono1, telefono2)
    @franja_horaria = franja_horaria
    @duracion = duracion
    @telefono_llamador = telefono1;
    @telefono_receptor = telefono2;
  end
end