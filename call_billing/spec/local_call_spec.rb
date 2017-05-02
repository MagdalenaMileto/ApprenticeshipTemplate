require 'rspec'

describe LlamadaLocal do

  let(:hora_pico) { FranjaHoraria.new(0.20) }
  let(:llamada_local) { LlamadaLocal.new(hora_pico, 5) }
  describe '#precio_por_duracion' do
    it 'retorna precio por duracion' do
      expect(llamada_local.precio_por_duracion).to eq(1)
    end
  end
end