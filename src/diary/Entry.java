package diary;

public class Entry {
    private String title;
    private String body;
    private String date;

    public Entry(String myStory, String date, String title) {
        this.body = myStory;
        this.date = date;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }
}
