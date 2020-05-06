package lesson06;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class l63 {
    private class MyClass {
        public static final String MONDAY1 = "MONDAY1";
        public static final String MONDAY = "MONDAY";
        public static final String SunDay = "SUNDAY";
        public String getDay() {return MONDAY;}
    }

    public static void printGetters(Class<?> clazz ){
        Method[] methods = clazz.getMethods();

        for(Method method : methods){
            if(isGetter(method)) System.out.println("getter: " + method);
        }
    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isConst(int modifiers){
        if (Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers))
            return true;
        else
            return false;
    }

    public static boolean checkClassFields(Class<?> clazz)
    {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Class fields:");
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (isConst(modifiers)  && field.getType().getTypeName()=="java.lang.String"){
                System.out.println("name="+ field.getName()+" type="+ field.getType().getTypeName());
                try  {
                    Object fieldValue = field.get(clazz);
                    System.out.println(fieldValue);
                    if (field.getName()!=fieldValue) {
                       return false;
                     }
                    } catch (Exception e) {
                        System.out.println("Error get value");
                    }
                 }
            }
        return true;
    }

    private static void printClassMethods(Class<?> clazz)
    {
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Class methods");
        for (Method method : methods) {
            System.out.println("Method name : " + method.getName());
            System.out.println("Return type : " +
                    method.getReturnType().getName());
            Class<?>[] params = method.getParameterTypes();
            System.out.print("Parameters : ");
            for (Class<?> param : params)
                System.out.print(" " + param.getName());
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Class myObjectClass = MyClass.class;
        printClassMethods(myObjectClass);
        printGetters(myObjectClass);
        if (checkClassFields(myObjectClass)) System.out.println("все строковые константы имеют значения, равные их имени ");
    }

}
