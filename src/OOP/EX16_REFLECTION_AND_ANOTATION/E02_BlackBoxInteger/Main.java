package OOP.EX16_REFLECTION_AND_ANOTATION.E02_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        // 1 create instance
        // 2 invoke methods
        // 3 print innerValue

        Constructor<BlackBoxInt> ctor = BlackBoxInt.class.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt boxInt = ctor.newInstance();

        Method[] methods = boxInt.getClass().getDeclaredMethods();
        Field innerValue = boxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String line;

        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("_");
            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            //Method method = boxInt.getClass().getDeclaredMethod(command, int.class);
            Method method = Arrays.stream(methods).filter(m -> m.getName().equals(command))
                    .findFirst().get();
            method.setAccessible(true);
            method.invoke(boxInt, param);

            System.out.println(innerValue.getInt(boxInt));

        }
    }
}
