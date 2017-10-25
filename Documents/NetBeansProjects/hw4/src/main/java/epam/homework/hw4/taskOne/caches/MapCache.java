package epam.homework.hw4.taskOne.caches;

import java.util.HashMap;
import java.util.Map;

@CacheDeclaration(name = "map")
public class MapCache implements Cache {

    private Map<Integer, String> cache;

    public MapCache() {
        cache = new HashMap<>();
    }

    @Override
    public void put(Integer key, String value) {
        cache.put(key, value);
    }

    @Override
    public String get(Integer byKey) {
        return cache.get(byKey);
    }
}
