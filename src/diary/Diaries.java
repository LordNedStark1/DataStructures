package diary;

import set.MySet;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private List<Diary> diaries= new ArrayList<Diary>();
    int diaryCounter = 1;

    public void signUp(String userName, String password) {
        Diary dairy = new Diary(userName, password);
        diaries.add(dairy);

    }

    public String login(String userName, String password) {
        for (int i = 0; i < diaries.size(); i++) {
            if (password == diaries.get(i).getPassword()) {

            }

        }
        String message = diaryCounter + " Welcome " + userName;
        diaryCounter++;
        return message;
    }

    public Diary findDiaryById(int diaryId) {
        for (int i = 0; i < diaries.size(); i++) {
            if (diaryId == diaries.get(i).getId()) {
                Diary dairy = diaries.get(i);
                return dairy;
            }
        }
        return null;
    }

    public int add(String myStory, String date, String title, int diaryId) {
        Entry entry = new Entry(myStory, date, title);
        for(Diary diary : diaries){
            if (diary.getId() == diaryId){
                diary.add(entry);
            }
        }
    }
}
