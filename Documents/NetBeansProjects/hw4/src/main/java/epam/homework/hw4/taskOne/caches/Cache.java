package epam.homework.hw4.taskOne.caches;

public interface Cache {

    public void put(Integer key, String value);

    public String get(Integer byKey);
}
