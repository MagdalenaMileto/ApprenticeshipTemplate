require 'rspec'

describe Factura do
  let(:hora_pico) { FranjaHoraria.new(0.20) }
  let(:hora_normal) { FranjaHoraria.new(0.10) }
  let(:facturador) { FacturadorLocal.new() }
  let(:factura) { Factura.new('Mayo', facturador) }

  describe '#monto_total' do
    context 'dada una factura con abono mensual basico' do
      let(:llamada_local) { Llamada.new(facturador, hora_pico, 5, 'Argentina', 'Argentina') }
      it 'retorna 10 pesos de pago basico' do
        expect(factura.monto_total).to eq(10)
      end
    end

    context 'dada una llamada local realizada en horario pico durante 5 minutos a un costo de 0.20 el minuto' do
      let(:llamada_local) { Llamada.new(facturador, hora_pico, 5, 'Argentina', 'Argentina') }
      it 'retorna 11 pesos' do
        factura.agregar_llamada(llamada_local)
        expect(factura.monto_total).to eq(11)
      end
    end

    context 'dada una llamada local realizada en horario normal durante 10 minutos a un costo de 0.10 el minuto' do
      let(:llamada_local) { Llamada.new(facturador, hora_normal, 10, 'Argentina', 'Argentina') }
      it 'returns 11' do
        factura.agregar_llamada(llamada_local)
        expect(factura.monto_total).to eq(11)
      end
    end

    context 'dada una llamada nacional de 5 minutos' do
      let(:factura) { Factura.new('Mayo', llamada_nacional) }
      it 'returns 11' do
        expect(llamada_nacional.gastos_llamadas).to eq(11.5)
      end
    end
  end
end