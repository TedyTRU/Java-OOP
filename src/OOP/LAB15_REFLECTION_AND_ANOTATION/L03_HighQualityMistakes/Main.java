package OOP.LAB15_REFLECTION_AND_ANOTATION.L03_HighQualityMistakes;

import OOP.LAB15_REFLECTION_AND_ANOTATION.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields)
                .sorted(Comparator.comparing(m -> m.getName()))
                .forEach(f -> {
                    if (!Modifier.isPrivate(f.getModifiers())) {
                        System.out.println(f.getName() + " must be private!");
                    }
                });


        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().contains("set") ||
                        m.getName().contains("get"))
                .sorted(Comparator.comparing(m -> m.getName()))
                .forEach(m -> printMethod(m));

    }

    public static void printMethod(Method method) {
        String out;

        if (method.getName().contains("set") && !Modifier.isPrivate(method.getModifiers())) {
            out = String.format("%s have to be private!", method.getName());

        } else if (method.getName().contains("get") && !Modifier.isPublic(method.getModifiers())) {
            out = String.format("%s have to be public!", method.getName());

        } else {

            return;
        }

        System.out.println(out);
    }

}
