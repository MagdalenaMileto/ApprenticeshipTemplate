require 'rspec'

describe Factura do

  let(:facturador_local) { FacturadorLocal.new() }
  let(:facturador_nacional) { FacturadorNacional.new() }
  let(:hora_pico) { FranjaHoraria.new(0.20) }
  let(:hora_normal) { FranjaHoraria.new(0.10) }
  let(:factura1) { Factura.new('Mayo', facturador_local) }

  describe '#monto_total' do
    context 'dada una factura con abono mensual basico' do
      let(:llamada_local) { Llamada.new(facturador_local, hora_pico, 5, 'Argentina', 'Argentina') }
      it 'retorna 10 pesos de pago basico' do
        expect(factura1.monto_total).to eq(10)
      end
    end

    context 'dada una llamada local realizada en horario pico durante 5 minutos a un costo de 0.20 el minuto' do
      let(:llamada_local) { Llamada.new(facturador_local, hora_pico, 5, 'Argentina', 'Argentina') }
      it 'retorna 11 pesos' do
        factura1.agregar_llamada(llamada_local)
        expect(factura1.monto_total).to eq(11)
      end
    end

    context 'dada una llamada local realizada en horario normal durante 10 minutos a un costo de 0.10 el minuto' do
      let(:llamada_local) { Llamada.new(facturador_local, hora_normal, 10, 'Argentina', 'Argentina') }
      it 'retorna 11 pesos' do
        factura1.agregar_llamada(llamada_local)
        expect(factura1.monto_total).to eq(11)
      end
    end

    context 'dada una llamada nacional de 5 minutos' do
      let(:llamada_nacional) { Llamada.new(facturador_nacional, hora_normal, 10, 'Argentina', 'Argentina') }
      let(:factura2) { Factura.new('Mayo', facturador_nacional) }
      it 'retorna 13 pesos' do
        factura2.agregar_llamada(llamada_nacional)
        expect(factura2.monto_total).to eq(13)
      end
    end

    context 'dada una llamada internacional a sudamerica durante 10 minutos' do
      it 'retorna 15 pesos' do
        let(:llamada_nacional) { Llamada.new(facturador_nacional, hora_normal, 10, 'Argentina', 'Argentina') }
        let(:factura2) { Factura.new('Mayo', facturador_nacional) }
      end
    end
  end
end