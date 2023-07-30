import java.lang.reflect.*;
public class Main {
    public static void main(String[] args) {
        // intercepting the class methods and fields using reflection
        printFieldsAndMethods("Employee");
        System.out.println("--------------------------------------------------");
       Employee obj = (Employee) instantiateObject("Employee");
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getSuperclass());
        
    }

    public static Object instantiateObject(String className) {
        try {
            Class<?> classsss = Class.forName(className);
            Constructor<?> constructor = classsss.getConstructor(int.class, int.class, String.class);
            Object obj = constructor.newInstance(10, 20, "Ahmed");
            return obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
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