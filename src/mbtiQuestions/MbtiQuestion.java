package mbtiQuestions;

import java.util.Map;
import java.util.TreeMap;

public class MbtiQuestion {
    Map<Integer, Question> questions = new TreeMap<>();
    int introvertCounter = 0;
    int extrovertCounter = 0;

    public int getIntrovertCounter() {
        return introvertCounter;
    }

    public int getExtrovertCounter() {
        return extrovertCounter;
    }

    public void saveNewQuestion(Question question) {
        questions.put(question.getQuestionNumber(), question);
    }

    public Question getQuestionByQuestionNumber(int questionNumber) {
        return questions.get(questionNumber);
    }
    public String toString() {
        return questions.toString();
    }

    public PersonalityType getPersonalityType() {
        return  determinePersonalityType();
    }

    private PersonalityType determinePersonalityType() {
            returnToZero();

         Object[] questionNumber = questions.keySet().toArray();
        for (Object obj : questionNumber) {

            PersonalityType personalityType = questions.get(obj).getUserPersonalityType();
            if (personalityType == PersonalityType.INTROVERT) introvertCounter++;
            if (personalityType == PersonalityType.EXTROVERT) extrovertCounter++;
        }

        if (introvertCounter > extrovertCounter) {
            return PersonalityType.INTROVERT;
        }
        else if (extrovertCounter > introvertCounter) {

            return PersonalityType.EXTROVERT;
        }

        return PersonalityType.BALANCE;
    }
    public void returnToZero() {
        introvertCounter = 0;
        extrovertCounter = 0;
    }

    public String displayMessageOnUserPersonalityType() {
        PersonalityType personalityType = determinePersonalityType();
        if (personalityType == PersonalityType.INTROVERT){

            return "Your solitude will be a support and a home for you," +
                    " even in the midst of very unfamiliar circumstances, and from it, you will find all your paths. " +
                    "\n You are an introvert with "+ introvertCounter + "count indicating so";
        } else if (personalityType == PersonalityType.EXTROVERT) {
            return "Extroversion is an enormously appealing personality style. " +
                    "An extrovert is more likely to share immediate " +
                    "reactions and process information through conversation. " +
                    "You are an extrovert with "+ extrovertCounter + " count indicating so";
        }
        return "You are quite balanced";
    }
}
