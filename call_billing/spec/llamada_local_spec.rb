require 'rspec'

describe FacturadorLocal do

  let(:llamada_local) { Llamada.new(facturador_local, hora_pico, 5, 'Argentina', 'Argentina')}
  let(:hora_pico) { FranjaHoraria.new(0.20) }
  let(:facturador_local) { FacturadorLocal.new() }
  describe '#precio_por_duracion' do
    it 'retorna precio por duracion' do
      expect(facturador_local.calcular_monto(hora_pico, 5)).to eq(1)
    end
  end
end