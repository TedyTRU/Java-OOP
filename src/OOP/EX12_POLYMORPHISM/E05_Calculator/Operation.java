package OOP.EX12_POLYMORPHISM.E05_Calculator;

public interface Operation {
    void addOperand(int operand);
    int getResult();
    boolean isCompleted();
}
