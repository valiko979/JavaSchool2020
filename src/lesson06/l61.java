package lesson06;

import java.lang.reflect.Modifier;

public class l61 {

    public static void printHierarchy(Class<?> clazz) {
        while (clazz != null) {
            System.out.println(clazz);
            clazz = clazz.getSuperclass();
        }
    }

    public static void printHierarchyInt(Class<?> clazz) {
        while (clazz != null) {
            Class[] interfaces = clazz.getInterfaces();
            for(Class aInterface : interfaces){
                System.out.println(clazz+" interface = " + aInterface.getName());
            }
            clazz = clazz.getSuperclass();
        }
    }


    public static void main(String[] args) {
        Class myObjectClass = String.class;
        int modifiers = myObjectClass.getModifiers();
        System.out.println("Модификаторы:");
        System.out.println("isAbstract = " + Modifier.isAbstract(modifiers));
        System.out.println("isFinal = " + Modifier.isFinal(modifiers));
        System.out.println("isInterface = " + Modifier.isInterface(modifiers));
        System.out.println("isNative = " + Modifier.isNative(modifiers));
        System.out.println("isPrivate = " + Modifier.isPrivate(modifiers));
        System.out.println("isProtected = " + Modifier.isProtected(modifiers));
        System.out.println("isPublic = " + Modifier.isPublic(modifiers));
        System.out.println("isStatic = " + Modifier.isStatic(modifiers));
        System.out.println("isStrict = " + Modifier.isStrict(modifiers));
        System.out.println("isSynchronized = " + Modifier.isSynchronized(modifiers));
        System.out.println("isTransient = " + Modifier.isTransient(modifiers));
        System.out.println("isVolatile = " + Modifier.isVolatile(modifiers));
        System.out.println("\nИмя пакета = " + myObjectClass.getName());
        System.out.println("\nКлассы иерархии:");
        printHierarchy(myObjectClass);
        System.out.println("\nРеализуемые интерфейсы для класса и для его родителей:");
        printHierarchyInt(myObjectClass);
    }

}
