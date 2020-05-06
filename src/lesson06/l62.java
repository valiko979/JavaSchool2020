package lesson06;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.Callable;

import static java.util.Collections.emptyList;

public class l62 {

    public class Runtime<T extends Number>
            implements Callable<Double> {
        private final List<Integer> integers = emptyList();

        public List<T> numbers() {return emptyList();}

        public List<String> strings() {return emptyList();}

        @Override
        public Double call() {return 0d;}
    }

    public static void getClassFields(Class<?> clazz)
    {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Class fields:");
        for (Field field : fields) {
            Class<?> fld = field.getType();
            System.out.println("field name : " + field.getName());
            System.out.println("field type : " + fld.getName());
        }
    }

    public static void main(String[] args) {
        Class myObjectClass = Runtime.class;
        getClassFields(myObjectClass);
    }

}
