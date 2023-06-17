package microunit.testrunner;

import microunit.InvalidTestClassException;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public abstract class TestRunner {
    private final Class<?> testClass;

    protected TestRunner(Class<?> testClass){
        this.testClass = testClass;
    }

    protected List<Method> getAnnotatedMethods(Class<? extends Annotation> annotationClass){
        return Arrays.stream(testClass.getDeclaredMethod())
                .filter(method->method.isAnnotationPresent(annotationClass))
                .toList();
    }

    public void runTestMethods() {
            try {
                for (Method method : getAnnotatedMethods(Test.class)) {
                    System.out.println(method);
                    Object instance = testClass.getConstructor().newInstance();
                }
            } catch (ReflectiveOperationException e) {
                throw new InvalidTestClassException(e);
            }
        }
    public void invokeTestMEthode(Method testMethod, Object instance) throws {
            try{
                test.Method.invoke(instance);
            } catch (InvocationTargetException e){
                Throwable cause = e.getCause();
                cause.printStackTrace(System.out);

            }
    }
}
