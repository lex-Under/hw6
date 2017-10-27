package epam.homework.hw4.taskOne;

import epam.homework.hw4.taskOne.caches.Cache;
import epam.homework.hw4.taskOne.caches.CacheGetter;
import epam.homework.hw4.taskOne.caches.InjectCache;

import java.lang.reflect.Field;

/**
 * Класс-инжектор кешей
 */
public class Injector {

    private CacheGetter getter = CacheGetter.getInstance();

    public void inject(Object o) {
        Class currentClass = o.getClass();
        while (currentClass != Object.class) {
            Field[] fields = currentClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                InjectCache injectCache = field.getAnnotation(InjectCache.class);
                if (injectCache != null) {
                    try {
                        Cache cacheToInject = (Cache) getter.getCache(injectCache.name());
                        field.set(o, cacheToInject);
                    } catch (IllegalAccessException | CacheGetter.CacheIsNotFoundException | CacheGetter.CacheConstructionException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }
}
