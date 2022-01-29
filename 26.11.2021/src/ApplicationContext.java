import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

public class ApplicationContext {

    private Map<String, Object> beans = new HashMap<>();

    @SneakyThrows
    public void init(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();

        List<Method> methodList = Arrays.stream(methods).sorted(Comparator.comparing(method -> method.getParameters().length)).collect(Collectors.toList());
        for (Method method : methodList) {
            if (method.isAnnotationPresent(Bean.class)) {
                method.setAccessible(true);
                Object[] parameters = new Object[method.getParameters().length];
                for (int i = 0; i < method.getParameters().length; i++) {
                    if (List.class.equals(method.getParameters()[i].getType())) {
                        parameters[i] = getBeans(((Class)((ParameterizedType) method.getParameters()[i].getParameterizedType()).getActualTypeArguments()[0]));
                    } else {
                        parameters[i] = getBean(method.getParameters()[i].getType());
                    }
                }
                String name;
                if ("".equals(method.getAnnotation(Bean.class).value())) {
                    name = method.getName();
                } else {
                    name = method.getAnnotation(Bean.class).value();
                }
                beans.put(name, method.invoke(null, parameters));
                method.setAccessible(false);
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.values().stream().filter(object -> clazz.isAssignableFrom(object.getClass())).findFirst().get();
    }

    public <T> List<T> getBeans(Class<T> clazz) {
        return (List<T>) beans.values().stream().filter(object -> clazz.isAssignableFrom(object.getClass())).collect(Collectors.toList());
    }

    public <T> T getBean(String name, Class<T> clazz) {
        return (T) beans.get(name);
    }
}
