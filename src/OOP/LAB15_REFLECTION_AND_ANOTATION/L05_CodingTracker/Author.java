package OOP.LAB15_REFLECTION_AND_ANOTATION.L05_CodingTracker;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
    String date();
}
