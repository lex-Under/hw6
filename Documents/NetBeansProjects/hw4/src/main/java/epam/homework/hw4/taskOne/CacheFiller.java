package epam.homework.hw4.taskOne;

import epam.homework.hw4.taskOne.caches.Cache;
import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Класс-заполнитель кешей
 */
public class CacheFiller {

    public void fill(Cache cache, Collection<?> fillData, String fieldNameKey, String fieldNameValue) {
        try {
            for (Object fillElem : fillData) {
                Field fieldKey = fillElem.getClass().getDeclaredField(fieldNameKey);
                fieldKey.setAccessible(true);
                Field fieldValue = fillElem.getClass().getDeclaredField(fieldNameValue);
                fieldValue.setAccessible(true);
                Integer key = (Integer) fieldKey.get(fillElem);
                String value = (String) fieldValue.get(fillElem);
                cache.put(key, value);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            System.out.println("Exception while filling cache: " + e.getMessage());
        }
    }

}
