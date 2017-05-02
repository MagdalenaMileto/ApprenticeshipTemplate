require 'rspec'

describe Factura do
  let(:abono_basico) { Llamada.new() }
  let(:hora_pico) { FranjaHoraria.new(0.20) }
  let(:hora_normal) { FranjaHoraria.new(0.10) }
  let(:llamada_nacional) { LlamadaNacionalOInternacional.new('Argentina', 'Brazil') }

  describe '#monto_total' do
    context 'dada una factura con abono mensual basico' do
      let(:factura) { Factura.new('Mayo', abono_basico) }
      it 'retorna 10 pesos de pago basico' do
        expect(abono_basico.monto_total).to eq(10)
      end
    end

    context 'dada una llamada local realizada en horario pico durante 5 minutos a un costo de 0.20 el minuto' do
      let(:llamada_local) { LlamadaLocal.new(hora_pico, 5) }
      let(:factura) { Factura.new('Mayo', llamada_local) }
      it 'retorna 11 pesos' do
        expect(llamada_local.monto_total).to eq(11)
      end
    end

    context 'dada una llamada local realizada en horario normal durante 10 minutos a un costo de 0.10 el minuto' do
      let(:llamada_local) { LlamadaLocal.new(hora_normal, 10) }
      let(:factura) { Factura.new('Mayo', llamada_local) }
      it 'returns 11' do
        expect(llamada_local.monto_total).to eq(11)
      end
    end

    context 'dada una llamada nacional de 5 minutos' do
      let(:factura) { Factura.new('Mayo', llamada_nacional) }
      it 'returns 11' do
        expect(llamada_nacional.total_amount).to eq(11.5)
      end
    end
  end
end