require 'spec_helper'

describe FibonacciSequence do
  let(:fibonacci) {FibonacciSequence.new}
  context 'when the position is 0' do
    it 'should return 0' do
      expect(fibonacci.number_for(0)).to eq(0)
    end
  end
end
