package diary;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String userName;
    private String password;
    private int id;
    private List<Entry> entries = new ArrayList<>();

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public Entry findEntryById(int id) {
        return new Entry("","", "");
    }

    public int getId() {
        return id;
    }

    public void add(Entry entry) {
        entries.add(entry);
    }
}
