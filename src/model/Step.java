package model;

public class Step {

    private int stepNumber;
    private String instruction;

    public Step(int stepNumber, String instruction) {
        this.stepNumber = stepNumber;
        this.instruction = instruction;
    }

    public Step() {
        this.stepNumber = 0;
        this.instruction = "";
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return stepNumber + ". " + instruction;
    }
}
