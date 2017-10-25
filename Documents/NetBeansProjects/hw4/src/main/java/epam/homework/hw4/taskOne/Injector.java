package epam.homework.hw4.taskOne;

import epam.homework.hw4.taskOne.caches.Cache;
import epam.homework.hw4.taskOne.caches.CacheDeclaration;
import epam.homework.hw4.taskOne.caches.InjectCache;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс-инжектор кешей
 */
public class Injector {

    /**
     * Отображение имяКеша - классКеша
     */
    private static Map<String, Class> cacheNamesClassesMap;
    /**
     * Инициализация 
     */
    static {
        try {
            cacheNamesClassesMap = new HashMap<>();
            String[] cachesFilenames = new File(Cache.class.getResource("").getFile()).list();
            String cachesPackage = "epam.homework.hw4.taskOne.caches";
            for (String filename : cachesFilenames) {
                if (filename.endsWith(".class")) {
                    String className = filename.substring(0, filename.lastIndexOf("."));  //removing '.class'
                    Class c = Class.forName(cachesPackage + "." + className);
                    CacheDeclaration cacheDeclaration = (CacheDeclaration) c.getAnnotation(CacheDeclaration.class);
                    if (Cache.class.isAssignableFrom(c)
                            && (cacheDeclaration != null)) {
                        cacheNamesClassesMap.put(cacheDeclaration.name(), c);
                    }
                }
            }
        } catch (ClassNotFoundException | NullPointerException e) {
            System.out.println("Something REAALLY wrong with caches! " + e.getMessage());
        }
    }

    public void inject(Object o) {
        Class currentClass = o.getClass();
        while (currentClass != Object.class) {
            Field[] fields = currentClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                InjectCache injectCache = field.getAnnotation(InjectCache.class);
                if (injectCache != null) {
                    try {
                        Class cacheClassToInit = cacheNamesClassesMap.get(injectCache.name());
                        if (cacheClassToInit != null) {
                            Cache cacheToInit = (Cache) cacheClassToInit.newInstance();
                            field.set(o, cacheToInit);
                        } else {
                            throw new CacheIsNotInjectedException("Кеш " + injectCache.name() + " не найден для класса " + currentClass.getName());
                        }
                    } catch (IllegalAccessException | InstantiationException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }
}
