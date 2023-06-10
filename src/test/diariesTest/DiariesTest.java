package test.diariesTest;

import diary.Diaries;
import diary.Diary;
import diary.Entry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiariesTest {

    Diaries diaries = new Diaries();
    @Test
    public  void testSignUpLoginLogin(){
        diaries.signUp("userName", "password");
      String message = diaries.login("userName", "password");

      assertEquals("1 Welcome userName", message);
    }
    @Test
    public void loginTest(){
        diaries.signUp("userName", "password");

        String message = diaries.login("userName", "password");
        int diaryId = Integer.parseInt("" + message.charAt(0));
        int id = diaries.add("my story", "date", "title", diaryId);

        Diary diary = diaries.findDiaryById(diaryId);

        Entry entry = diary.findEntryById(id);

        assertEquals(entry.getBody(), "my story");
        assertEquals(entry.getDate(), "date");





    }
}
