package OOP.LAB15_REFLECTION_AND_ANOTATION.L01_Reflection;

import OOP.LAB15_REFLECTION_AND_ANOTATION.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // this class type

        Class reflection = Reflection.class;
        System.out.println(reflection);



//        Class<Reflection> clazz = Reflection.class;
//        System.out.println(clazz.getSimpleName());

        // super class type

        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);



//        System.out.println(clazz.getSuperclass().getSimpleName());

        // all interfaces that are implemented by this class

        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }



//        Class<?>[] interfaces2 = clazz.getInterfaces();
//        for (Class<?> aClass : interfaces2) {
//            System.out.println(aClass.getSimpleName());
//        }


        // instantiate object using reflection

        Object reflectionObject = reflection.getDeclaredConstructor()
                .newInstance();
        System.out.println(reflectionObject);



//        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
//        Reflection reflection1 = ctor.newInstance();
//        System.out.println(reflection1);

    }
}
