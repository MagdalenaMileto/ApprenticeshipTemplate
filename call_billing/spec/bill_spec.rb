require 'rspec'

describe Bill do
  let(:bill) { Bill.new('Mayo') }

  describe '#total_amount' do
    context 'given a basic call billing' do
      it 'returns basic payment' do
        expect(bill.total_amount).to eq(10)
      end
    end
  end
end