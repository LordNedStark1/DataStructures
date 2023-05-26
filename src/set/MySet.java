package set;

import arrayList.MyArrayList;
import arrayList.MyList;

public class MySet<S> {
    MyList<S> elements = new MyArrayList<>();
    public void add(S value) {
        if (!isPresent(value)) elements.add(value);
    }

    public boolean isPresent(S value) {
        boolean checkedPresence = false;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == value) checkedPresence = true;
        }
        return checkedPresence;
    }

    public long size() {
        return elements.size();
    }
    public String toString() {
        String stringValue = elements.toString();
        StringBuilder listContent = new StringBuilder();

        return listContent.append("{")
                .append( stringValue.substring(1, stringValue.length() -1))
                .append("}")
                .toString();


    }
}

