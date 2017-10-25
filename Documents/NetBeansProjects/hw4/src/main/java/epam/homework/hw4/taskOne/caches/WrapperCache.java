package epam.homework.hw4.taskOne.caches;

import java.util.ArrayList;
import java.util.List;

@CacheDeclaration(name = "wrapper")
public class WrapperCache implements Cache {

    private List<Wrapper> wrappers;

    public WrapperCache() {
        wrappers = new ArrayList<>();
    }

    @Override
    public void put(Integer key, String value) {
        wrappers.add(new Wrapper(key, value));
    }

    @Override
    public String get(Integer byKey) {
        for (Wrapper w : wrappers) {
            if (w.getKey().equals(byKey)) {
                return w.getValue();
            }
        }
        return null;
    }

    public class Wrapper {

        private Integer key;
        private String value;

        public Integer getKey() {
            return key;
        }

        public String getValue() {    //извините
            return value;
        }

        public Wrapper(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
