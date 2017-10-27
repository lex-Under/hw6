package epam.homework.hw4.taskOne.caches;

import epam.homework.hw4.taskOne.entities.Student;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Класс-заполнитель кешей
 */
public class CacheFiller {

    /**
     * Данные для заполнения по умолчанию
     */
    private List<Student> defaultFillData;

    public CacheFiller() {
        defaultFillDataInit();
    }

    /**
     * Метод заполнения кэша данными по умолчанию
     */
    public void fill(Cache cache) {
        if (cache instanceof MapCache) {
            fill(cache, defaultFillData, "markbookNo", "name");
        } else if (cache instanceof WrapperCache) {
            fill(cache, defaultFillData, "passportNo", "name");
        } else {
            System.out.println("The cache " + cache.getClass().getName() + " not supported for default fill() yet");
        }
    }

    /**
     * Обобщённый метод заполнения кэша данными
     */
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

    private void defaultFillDataInit() {
        defaultFillData = new ArrayList<>(5);
        defaultFillData.add(new Student("Иванов Дмитрий Иванович", 22, 6422, 1921, 4, "Информатика и вычислительная техника"));
        defaultFillData.add(new Student("Пензина Евгения Константиновна", 22, 6423, 1922, 5, "Автоматизированные системы управления"));
        defaultFillData.add(new Student("Болгов Артем Игоревич", 18, 6025, 575, 1, "Экономика и статистика"));
        defaultFillData.add(new Student("Васильев Денис Филиппович", 17, 5925, 576, 1, "Экономика и статистика"));
        defaultFillData.add(new Student("Горшкова Альбина Вартановна", 20, 6281, 1024, 2, "Прикладная математика"));
    }

}
