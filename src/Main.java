import java.lang.reflect.*;
public class Main {
    public static void main(String[] args) {
        // intercepting the class methods and fields using reflection
        printFieldsAndMethods("Employee");
        System.out.println("--------------------------------------------------");
        instantiateObject("Employee");

    }

    public static void instantiateObject(String className) {
        try {
            Class<?> classsss = Class.forName(className);
            Constructor<?> constructor = classsss.getConstructor(int.class, int.class, String.class);
            Object obj = constructor.newInstance(10, 20, "Ahmed");
            System.out.println(obj.getClass());
            System.out.println(obj.getClass().getSuperclass());
            System.out.print("implements:  ");
            Class<?>[] interfaces =  obj.getClass().getInterfaces();
            for (Class<?> anInterface : interfaces) {
                System.out.print(anInterface);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void printFieldsAndMethods(String className) {
        try {
            Class<?> c = Class.forName(className);
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getDeclaredMethods();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println(field.getName());
                System.out.println("Access Modifier: " + Modifier.toString(field.getModifiers()));
                System.out.println("Type: " + field.getType());
            }
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());
                System.out.println("Access Modifier: " + Modifier.toString(method.getModifiers()));
                System.out.println("Return Type: " + method.getReturnType());
                System.out.print("Parameters: ");
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.print(parameter.getType() + " " + parameter.getName() +" ,");
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}