package epam.homework.hw4.taskOne.caches;

import java.io.File;
import java.util.HashMap;

/**
 * Класс для получения конкретного инстанса кеша по заданному имени
 *
 * @CacheDeclaration (Singletone)
 */
public class CacheGetter {

    private CacheFiller filler;
    private static CacheGetter getter;
    HashMap<String, Class> namesClassesMap;

    private CacheGetter() {
        try {
            filler = new CacheFiller();
            namesClassesMap = new HashMap<>();
            String[] cachesFilenames = new File(this.getClass().getResource("").getFile()).list();
            String cachesPackage = "epam.homework.hw4.taskOne.caches";
            for (String filename : cachesFilenames) {
                if (filename.endsWith(".class")) {
                    String className = filename.substring(0, filename.lastIndexOf("."));  //removing '.class'
                    Class c = Class.forName(cachesPackage + "." + className);
                    CacheDeclaration cacheDeclaration = (CacheDeclaration) c.getAnnotation(CacheDeclaration.class);
                    if (Cache.class.isAssignableFrom(c)
                            && (cacheDeclaration != null)) {
                        namesClassesMap.put(cacheDeclaration.name(), c);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Something REAALLY wrong with caches! " + e.getMessage());
        }
    }

    public static CacheGetter getInstance() {
        if (getter == null) {
            getter = new CacheGetter();
        }
        return getter;
    }

    public Cache getCache(String nameCacheDeclaration) throws CacheIsNotFoundException, CacheConstructionException {
        try {
            Cache result = (Cache) namesClassesMap.get(nameCacheDeclaration).newInstance();
            if (result == null) {
                throw new CacheIsNotFoundException("Кеш (name = " + nameCacheDeclaration + ") не найден.");
            } else {
                filler.fill(result);
                return result;
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new CacheConstructionException("Ошибка при инициализации кеша: " + ex.getMessage());
        }
    }

    public class CacheConstructionException extends Exception {

        public CacheConstructionException() {
            super();
        }

        public CacheConstructionException(String s) {
            super(s);
        }
    }

    public class CacheIsNotFoundException extends Exception {

        public CacheIsNotFoundException() {
            super();
        }

        public CacheIsNotFoundException(String s) {
            super(s);
        }
    }
}
