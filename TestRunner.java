import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

    public static void main(String[] args) {

        Class<?> cls = TestClass.class;

        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test testAnnot = method.getAnnotation(Test.class);
                try {
                    method.invoke(cls.getConstructor().newInstance(), testAnnot.a(), testAnnot.b());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

}
