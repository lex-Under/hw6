package epam.homework.hw4.taskOne.entities;

import epam.homework.hw4.taskOne.caches.Cache;
import epam.homework.hw4.taskOne.caches.InjectCache;

/**
 * Хранилище студентов, осуществляющее доступ к студентам по номеру зачетной
 * книжки
 */
public class GroupByMarkbook extends GroupDefault {

    @InjectCache(name = "map")
    private Cache cacheByMarkbook;

    public String getByMarkbook(Integer markbookNo) {
        return cacheByMarkbook.get(markbookNo);
    }

    public Cache getCacheByMarkbook() {
        return cacheByMarkbook;
    }

}
