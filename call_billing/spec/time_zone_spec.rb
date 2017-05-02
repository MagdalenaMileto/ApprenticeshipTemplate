require 'rspec'

describe FranjaHoraria do
  let(:hora_pico) { FranjaHoraria.new(0.20) }
  describe '#precio_por_minuto' do
    it 'retorna 0.20' do
      expect(hora_pico.precio_por_minuto).to eq(0.20)
    end
  end

  let(:hora_normal) { FranjaHoraria.new(0.10) }
  describe '#precio_por_minuto' do
    it 'retorna 0.10' do
      expect(hora_normal.precio_por_minuto).to eq(0.10)
    end
  end
end