package test.mbti;

import mbtiQuestions.MbtiQuestion;
import mbtiQuestions.PersonalityType;
import mbtiQuestions.Question;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

import static mbtiQuestions.PersonalityType.EXTROVERT;
import static mbtiQuestions.PersonalityType.INTROVERT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MbtiTest {
    int count = 0;
    MbtiQuestion mbtiQuestion = new MbtiQuestion();
    @Test
    public void adminCreateQuestion(){
//        simulateApp();
//        presentationMode();
        Question question = new Question();
        question.setQuestionToAsk("You regularly make new friends?");
        assertEquals("You regularly make new friends?",question.getQuestionToAsk());
    }
    @Test
    public void adminCanAddTwoPossibleAnswersToAQuestion(){
        Question question = new Question();
        question.setQuestionToAsk("You regularly make new friends?");
        assertEquals("You regularly make new friends?",question.getQuestionToAsk());

        question.setOptionA("Yes, I love making new friends", INTROVERT);
        question.setOptionB("No, I don't really like making new friends", EXTROVERT);

        assertEquals("Yes, I love making new friends", question.getOptionA());
        assertEquals("No, I don't really like making new friends", question.getOptionB());
    }
    @Test
    public void adminCanSetPersonalityTypeDeterminantForEachOption(){
        Question question = new Question();
        question.setQuestionToAsk("You regularly make new friends?");
        assertEquals("You regularly make new friends?",question.getQuestionToAsk());

        question.setOptionA("Yes, I love making new friends",   EXTROVERT);
        question.setOptionB("No, I don't really like making new friends", INTROVERT);

        assertEquals(EXTROVERT, question.getOptionAPersonalityType());
        assertEquals(INTROVERT, question.getOptionBPersonalityType());

    }
    @Test
    public void userCanDeclareAnswer(){
        Question question = new Question();

        question.setQuestionToAsk("You regularly make new friends?");
        question.setOptionA("Yes, I love making new friends", EXTROVERT);
        question.setOptionB("No, I don't really like making new friends", INTROVERT);

        question.setUserAnswer("a");

        assertEquals(EXTROVERT, question.getUserPersonalityType());

    }
    @Test
    public void questionsCanBeAddedForUsers(){
        MbtiQuestion mbtiQuestion = new MbtiQuestion();
        Question question = new Question();

        question.setQuestionToAsk("You regularly make new friends?");
        question.setOptionA("Yes, I love making new friends", EXTROVERT);
        question.setOptionB("No, I don't really like making new friends", INTROVERT);
        question.setQuestionNumber(1);

        mbtiQuestion.saveNewQuestion(question);
        assertEquals("You regularly make new friends?", mbtiQuestion.getQuestionByQuestionNumber(1).getQuestionToAsk());
        assertEquals("Yes, I love making new friends", mbtiQuestion.getQuestionByQuestionNumber(1).getOptionA());
        assertEquals(INTROVERT, mbtiQuestion.getQuestionByQuestionNumber(1).getOptionBPersonalityType());
    }
    @Test
    public void ensureThatUsersCanDetermineTheirPersonalityFromMbtiQuestions(){
        setQuestions();

       takeTest();

        // determine personality
        assertEquals(EXTROVERT, mbtiQuestion.getPersonalityType());
        assertEquals(12, mbtiQuestion.getExtrovertCounter());
        assertEquals(8, mbtiQuestion.getIntrovertCounter());

        // display result
        String messageBasedOnPersonalityType = "Extroversion is an enormously appealing personality style. \n" +
                "An extrovert is more likely to share immediate \n" +
                "reactions and process information through conversation. \n" +
                "You are an extrovert with "+ 12 + " count indicating so";
        assertEquals(messageBasedOnPersonalityType,mbtiQuestion.displayMessageOnUserPersonalityType());
    }
    // ApplicationMain
    public void takeTest(){

        for (int i = 0; i < 20; i++) {
            if(count == 5) count = 0;
            Question questionAsked = mbtiQuestion.getQuestionByQuestionNumber(i + 1);

            assertEquals(questions[count], questionAsked.getQuestionToAsk());

            questionAsked.setUserAnswer("a");
            count++;
        }
    }
    public void takeTestManually(){
        Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 5; ) {
                if(count == 5) count = 0;
                Question questionAsked = mbtiQuestion.getQuestionByQuestionNumber(i + 1);

                System.out.println("Question " +( i+1)+": "+questionAsked.getQuestionToAsk());
                System.out.println("\noption A: " +questionAsked.getOptionA());
                System.out.println("option B: " +questionAsked.getOptionB());
                System.out.println("\nEnter either a or b");
                String answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b")) {
                    questionAsked.setUserAnswer(answer);
                    count++;
                    i++;
                }
                else{
                    System.out.println("not a valid answer");
                }
            }

    }
    public void simulateTest(){


            for (int i = 0; i < 20; i++) {
                if (count == 5) count = 0;
                Question questionAsked = mbtiQuestion.getQuestionByQuestionNumber(i + 1);

                assertEquals(questions[count], questionAsked.getQuestionToAsk());

                String userAnswer = randomizeUserAnswer();
                questionAsked.setUserAnswer(userAnswer);
                count++;
            }
    }
    public void setQuestions( ){

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
    }
    public void presentationMode(){
        System.out.println("Enter your name ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        setQuestions();
        takeTestManually();
        System.out.println(name);
        System.out.println(mbtiQuestion.displayMessageOnUserPersonalityType());
    }
    private String randomizeUserAnswer() {
        Random random = new Random();
        int choice = random.nextInt(2);
        if (choice == 1) return "A";
        else return "B";
    }
    public void simulateApp(){
        setQuestions();
        simulateTest();
        System.out.println(mbtiQuestion.displayMessageOnUserPersonalityType());
    }
    String [] questions = {
            "Do You regularly make new friends?",
            "You spend a lot of your free time exploring various random topics that pique your interest? ",
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
            EXTROVERT,
            EXTROVERT,
            INTROVERT,
            INTROVERT,
            EXTROVERT
    };
    String [] optionBs = {
            "No, I don't really like making new friends",
            "yes, of course",
            "no, i always take life as it comes",
            "No, bad situations can me me even cry",
            "yes, i love even keeping to myself alot"
    };
    PersonalityType [] optionBPersonalityTypes = {
            INTROVERT,
            INTROVERT,
            EXTROVERT,
            EXTROVERT,
            INTROVERT
    };
}
