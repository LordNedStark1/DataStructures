package String;

import org.testng.mustache.Value;

public final class MyString{
   private Object value ;
    private MyString(Object value) {
        this.value = value;
    }

    public  MyString createString(Object value) {
            Object va = value;
        return new MyString(va);
    }
    public 
}
