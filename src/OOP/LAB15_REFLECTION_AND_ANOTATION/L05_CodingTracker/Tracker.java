package OOP.LAB15_REFLECTION_AND_ANOTATION.L05_CodingTracker;

import java.util.Arrays;
import java.util.Comparator;

public class Tracker {

    public static void printMethodsByAuthor(Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getDeclaredAnnotation(Author.class) != null)
                .sorted(Comparator.comparing(m -> m.getDeclaredAnnotation(Author.class).name()))
                .forEach(m -> {
                    System.out.println(m.getDeclaredAnnotation(Author.class).name() + ": " + m.getName()
                    + m.getDeclaredAnnotation(Author.class).date());
                });
    }

}
