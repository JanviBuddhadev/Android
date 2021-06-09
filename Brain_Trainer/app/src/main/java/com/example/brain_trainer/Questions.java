package com.example.brain_trainer;

public class Questions {
    private String que;
    private String option1;
    private String option2;
    private String option3;
    private int correct;

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
    public Questions()
    {

    }
    public Questions(String que, String option1, String option2, String option3, int correct) {
        this.que = que;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correct = correct;
    }

}
