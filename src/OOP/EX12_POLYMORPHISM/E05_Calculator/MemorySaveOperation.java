package OOP.EX12_POLYMORPHISM.E05_Calculator;

import java.util.Deque;

public class MemorySaveOperation implements Operation{

    private Deque<Integer> memory;

    public MemorySaveOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        //return !this.memory.isEmpty();
        //return this.memory.size() != 0;
        return false;
    }
}
