package OOP.LAB07_INHERITANCE.E05_RandomArrayList;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    public Object getRandomElement() {
        int index = ThreadLocalRandom.current().nextInt(super.size());
        return remove(index);
    }


}
