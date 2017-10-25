package epam.homework.hw4.taskOne.entities;

import epam.homework.hw4.taskOne.caches.Cache;
import epam.homework.hw4.taskOne.caches.InjectCache;

/**
 * Хранилище студентов, осуществляющее доступ к студентам по паспорту
 */
public class GroupDefault {

    @InjectCache(name = "wrapper")
    private Cache cacheByPassport;

    public String getByPassportNo(Integer passportNo) {
        return cacheByPassport.get(passportNo);
    }

    public Cache getCacheByPassport() {
        return cacheByPassport;
    }

}
