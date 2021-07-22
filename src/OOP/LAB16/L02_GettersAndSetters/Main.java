package OOP.LAB16.L02_GettersAndSetters;

import OOP.LAB16.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().contains("set") ||
                        m.getName().contains("get"))
                .sorted(Comparator.comparing(m -> m.getName()))
                .forEach(m -> printMethod(m));

    }

    public static void printMethod(Method method) {

        String out = method.getName().contains("set")

                ? String.format("%s and will set field of %s",
                method.getName(), formatType(method.getParameterTypes()[0]))

                : String.format("%s will return %s",
                method.getName(), formatType(method.getReturnType()));

        System.out.println(out);
    }

    public static String formatType(Class<?> type) {
        return type == int.class ? "class " + type : type.toString();
    }
}
