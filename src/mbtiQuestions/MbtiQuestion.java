package mbtiQuestions;

import java.util.Map;
import java.util.TreeMap;

import static mbtiQuestions.PersonalityType.EXTROVERT;
import static mbtiQuestions.PersonalityType.INTROVERT;

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
            if (personalityType == INTROVERT) introvertCounter++;
            if (personalityType == EXTROVERT) extrovertCounter++;
        }

        if (introvertCounter > extrovertCounter) {
            return INTROVERT;
        }
        else if (extrovertCounter > introvertCounter) {

            return EXTROVERT;
        }

        return PersonalityType.BALANCE;
    }
    public void returnToZero() {
        introvertCounter = 0;
        extrovertCounter = 0;
    }

    public String displayMessageOnUserPersonalityType() {
        PersonalityType personalityType = determinePersonalityType();
        if (personalityType == INTROVERT){

            return "Your solitude will be a support and a home for you," +
                    "\n even in the midst of very unfamiliar circumstances, and from it, " +
                    "\nyou will find all your paths. " +
                    "\n You are an introvert with "+ introvertCounter + " count indicating so";
        } else if (personalityType == EXTROVERT) {

            return "Extroversion is an enormously appealing personality style. \n" +
                    "An extrovert is more likely to share immediate \n" +
                    "reactions and process information through conversation. \n" +
                    "You are an extrovert with "+ extrovertCounter + " count indicating so";
        }
        return """
                You are quite balanced.\s
                A balanced personality is marked by\s
                good physical appearance, emotional stability, higher intellectual ability,
                 higher degree of social adjustment""";
    }
}
