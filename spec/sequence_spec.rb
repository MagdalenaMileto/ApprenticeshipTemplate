require 'spec_helper'

describe FibonacciSequence do
  let(:fibonacci) {FibonacciSequence.new}
  context 'when the position is 0' do
    it 'should return 0' do
      expect(fibonacci.number_for(0)).to eq(0)
    end
  end

  context 'when the position is 1' do
    it 'should return 1' do
      expect(fibonacci.number_for(1)).to eq(1)
    end
  end
end
