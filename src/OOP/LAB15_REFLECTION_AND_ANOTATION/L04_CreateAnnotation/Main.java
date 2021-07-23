package OOP.LAB15_REFLECTION_AND_ANOTATION.L04_CreateAnnotation;

import OOP.LAB15_REFLECTION_AND_ANOTATION.Reflection;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {

        Class clazz = Reflection.class;

        Annotation[] annotations = clazz.getAnnotations();
        System.out.println();

    }
}
