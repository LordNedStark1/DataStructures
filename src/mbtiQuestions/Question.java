package mbtiQuestions;


public class Question {
    private String questionToAsk;
    private String optionA;
    private String optionB;
    private String userAnswer;
    private PersonalityType userPersonalityType;
    private PersonalityType optionAPersonalityType;
    private int questionNumber;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public PersonalityType getOptionAPersonalityType() {
        return optionAPersonalityType;
    }

    public void setOptionAPersonalityType(PersonalityType optionAPersonalityType) {
        this.optionAPersonalityType = optionAPersonalityType;
    }

    public PersonalityType getOptionBPersonalityType() {
        return optionBPersonalityType;
    }

    public void setOptionBPersonalityType(PersonalityType optionBPersonalityType) {
        this.optionBPersonalityType = optionBPersonalityType;
    }

    private PersonalityType optionBPersonalityType;

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA, PersonalityType personalityType) {
        this.optionA = optionA;
        this.optionAPersonalityType = personalityType;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB, PersonalityType personalityType) {
        this.optionB = optionB;
        this.optionBPersonalityType = personalityType;
    }

    public String getQuestionToAsk() {
        return questionToAsk;
    }

    public void setQuestionToAsk(String questionToAsk) {
        this.questionToAsk = questionToAsk;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
        determinePersonalityType();
    }
    public String getUserAnswer() {
        return userAnswer;
    }

    public PersonalityType getUserPersonalityType() {
        return userPersonalityType;
    }

    private void determinePersonalityType() {
        if (userAnswer.equalsIgnoreCase("a")){
            userPersonalityType = optionAPersonalityType;
        } else if (userAnswer.equalsIgnoreCase("b")){
            userPersonalityType = optionBPersonalityType;
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "\nquestionToAsk='" + questionToAsk + '\'' +
                ",\n optionA='" + optionA + '\'' +
                ",\n optionB='" + optionB + '\'' +
                ",\n userAnswer='" + userAnswer + '\'' +
                ",\n userPersonalityType=" + userPersonalityType +
                ",\n optionAPersonalityType=" + optionAPersonalityType +
                ",\n questionNumber=" + questionNumber +
                ",\n optionBPersonalityType=" + optionBPersonalityType +
                '}';
    }
}
