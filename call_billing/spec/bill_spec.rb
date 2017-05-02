require 'rspec'

describe Bill do
  let(:basic_payment) { Call.new() }
  let(:local_call) { LocalCall.new() }

  describe '#total_amount' do
    context 'given a basic call billing' do
      let(:bill) { Bill.new('Mayo', basic_payment) }
      it 'returns basic payment' do
        expect(basic_payment.total_amount).to eq(10)
      end
    end

    context 'given a local call made on a business day for 5 minutes at a cost of 0.20 a minute' do
      let(:bill) { Bill.new('Mayo', local_call) }
      it 'returns 11' do
        expect(local_call.total_amount).to eq(11)
      end
    end
  end
end