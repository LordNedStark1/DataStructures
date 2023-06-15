package test.mbti;

import mbtiQuestions.MbtiQuestion;
import mbtiQuestions.PersonalityType;
import mbtiQuestions.Question;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MbtiTest {

    @Test
    public void adminCreateQuestion(){
        Question question = new Question();
        question.setQuestionToAsk("You regularly make new friends?");
        assertEquals("You regularly make new friends?",question.getQuestionToAsk());
    }
    @Test
    public void adminCanAddTwoPossibleAnswersToAQuestion(){
        Question question = new Question();
        question.setQuestionToAsk("You regularly make new friends?");
        assertEquals("You regularly make new friends?",question.getQuestionToAsk());

        question.setOptionA("Yes, I love making new friends", PersonalityType.INTROVERT);
        question.setOptionB("No, I don't really like making new friends", PersonalityType.EXTROVERT);

        assertEquals("Yes, I love making new friends", question.getOptionA());
        assertEquals("No, I don't really like making new friends", question.getOptionB());
    }
    @Test
    public void adminCanSetPersonalityTypeDeterminantForEachOption(){
        Question question = new Question();
        question.setQuestionToAsk("You regularly make new friends?");
        assertEquals("You regularly make new friends?",question.getQuestionToAsk());

        question.setOptionA("Yes, I love making new friends", PersonalityType.EXTROVERT);
        question.setOptionB("No, I don't really like making new friends", PersonalityType.INTROVERT);

        assertEquals(PersonalityType.EXTROVERT, question.getOptionAPersonalityType());
        assertEquals(PersonalityType.INTROVERT, question.getOptionBPersonalityType());

    }
    @Test
    public void userCanDeclareAnswer(){
        Question question = new Question();

        question.setQuestionToAsk("You regularly make new friends?");
        question.setOptionA("Yes, I love making new friends", PersonalityType.EXTROVERT);
        question.setOptionB("No, I don't really like making new friends", PersonalityType.INTROVERT);

        question.setUserAnswer("a");

        assertEquals(PersonalityType.EXTROVERT, question.getUserPersonalityType());

    }
    @Test
    public void questionsCanBeAddedForUsers(){
        MbtiQuestion mbtiQuestion = new MbtiQuestion();
        Question question = new Question();

        question.setQuestionToAsk("You regularly make new friends?");
        question.setOptionA("Yes, I love making new friends", PersonalityType.EXTROVERT);
        question.setOptionB("No, I don't really like making new friends", PersonalityType.INTROVERT);
        question.setQuestionNumber(1);

        mbtiQuestion.saveNewQuestion(question);
        assertEquals("You regularly make new friends?", mbtiQuestion.getQuestionByQuestionNumber(1).getQuestionToAsk());
        assertEquals("Yes, I love making new friends", mbtiQuestion.getQuestionByQuestionNumber(1).getOptionA());
        assertEquals(PersonalityType.INTROVERT, mbtiQuestion.getQuestionByQuestionNumber(1).getOptionBPersonalityType());
    }
    @Test
    public void ensureThatUsersCanDetermineTheirPersonalityFromMbtiQuestions(){
        MbtiQuestion mbtiQuestion = new MbtiQuestion();

        String [] questions = {
                "You regularly make new friends.",
                "You spend a lot of your free time exploring various random topics that pique your interest. ",
                "You often make a backup plan for a backup plan. ",
                "You usually stay calm, even under a lot of pressure.",
                "At social events, you rarely try to introduce yourself to new people and mostly talk to the ones you already know. "
        };
        String [] optionAs = {
                "Yes, I love making new friends",
                "not really, i love to have fun",
                "always do, i never forget to do so",
                "yes very calm to tough situations",
                "I love meeting new people at social events"
        };
        PersonalityType [] optionAPersonalityTypes = {
                PersonalityType.EXTROVERT,
                PersonalityType.EXTROVERT,
                PersonalityType.INTROVERT,
                PersonalityType.INTROVERT,
                PersonalityType.EXTROVERT
        };
        String [] optionBs = {
                "No, I don't really like making new friends",
                "yes, of course",
                "no, i always take life as it comes",
                "No, bad situations can me me even cry",
                "yes, i love even keeping to myself alot"
        };
        PersonalityType [] optionBPersonalityTypes = {
                PersonalityType.INTROVERT,
                PersonalityType.INTROVERT,
                PersonalityType.EXTROVERT,
                PersonalityType.EXTROVERT,
                PersonalityType.INTROVERT
        };
    // set questions
        int count = 0;
        for (int i = 0; i < 20 ; i++) {
            if(count == 5) count = 0;

          Question question = new Question();

          question.setQuestionToAsk(questions[count]);
          question.setOptionA(optionAs[count], optionAPersonalityTypes[count]);
          question.setOptionB(optionBs[count], optionBPersonalityTypes[count]);
          question.setQuestionNumber( i + 1);

          mbtiQuestion.saveNewQuestion(question);
          count++;
        }
        // take response;
        for (int i = 0; i < 20; i++) {
            if(count == 5) count = 0;
           Question questionAsked = mbtiQuestion.getQuestionByQuestionNumber(i + 1);

           assertEquals(questions[count], questionAsked.getQuestionToAsk());

           String userAnswer = getUserAnswer();
           questionAsked.setUserAnswer("a");
            count++;
        }
        // determine personality
        assertEquals(PersonalityType.EXTROVERT, mbtiQuestion.getPersonalityType());

        // display result
        String messageBasedOnPersonalityType = "Extroversion is an enormously appealing personality style. " +
                "An extrovert is more likely to share immediate " +
                "reactions and process information through conversation. " +
                "You are an extrovert with "+ 12 + " count indicating so";
        assertEquals(messageBasedOnPersonalityType,mbtiQuestion.displayMessageOnUserPersonalityType());
    }
    private String getUserAnswer() {
        Random random = new Random();
        int choice = random.nextInt(2);
        if (choice == 1) return "A";
        else return "B";
    }
}
