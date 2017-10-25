package epam.homework.hw4.taskTwo;

import epam.homework.hw4.taskTwo.model.Author;
import epam.homework.hw4.taskTwo.model.Book;

import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoTaskTwo {

    List<Author> authors = new ArrayList<>();
    List<Book> books = new ArrayList<>();

    public double averageAge(List<Author> authors) {
        if (authors.isEmpty()) {
            return Double.NaN;
        } else {
            return authors.stream()
                    .mapToLong(Author::getAge)
                    .average().getAsDouble();
        }
    }

    public List<Author> sortByAge(List<Author> authors) {
        return authors.stream()
                .sorted(Comparator.comparingInt(Author::getAge))
                .collect(Collectors.toList());
    }

    public List<Author> pensioners(List<Author> authors) {
        return authors.stream()
                .filter(a -> {
                    return (a.getGender() == Author.Gender.male)
                            ? !(a.isDead()) && (a.getAge() > 65)
                            : !(a.isDead()) && (a.getAge() > 63);
                })
                .collect(Collectors.toList());
    }

    public List<String> namesAndAges(List<Book> books) {
        return books.stream()
                .map(book -> "name: " + book.getName() + ", age: " + book.getAge())
                .collect(Collectors.toList());
    }

    public List<Author> coauthors(List<Book> books) {
        return books.stream()
                .filter(b -> b.getAuthors().size() > 1)
                .flatMap(b -> b.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> booksByAuthors(List<Author> authors, List<Book> books) {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream()
                        .map(author -> new SimpleEntry<>(author, book)))
                .collect(Collectors.groupingBy(
                        e -> e.getKey().getName(),
                        Collectors.mapping(e -> e.getValue().getName(), Collectors.toList())));
    }

    public void launch() {

        init();
        System.out.println("\nСписок всех авторов:");
        authors.stream().forEach(System.out::println);
        System.out.println("\nСписок всех книг:");
        books.stream().forEach(System.out::println);
        System.out.println("\nСредний возраст авторов: " + averageAge(authors));
        System.out.println("\nСписок авторов, отсортированный по возрастанию возраста:");
        sortByAge(authors).stream().forEach(System.out::println);
        System.out.println("\nАвторы-пенсионеры:");
        pensioners(authors).stream().forEach(System.out::println);
        System.out.println("\nКнига --- возраст книги:");
        namesAndAges(books).stream().forEach(System.out::println);
        System.out.println("\nСписок всех авторов, писавших в соавторстве с кем-либо:");
        coauthors(books).stream().forEach(System.out::println);
        System.out.println("\nАвтор --- книги автора:");
        booksByAuthors(authors, books).entrySet().stream().forEach(System.out::println);

    }

    private void init() {
        Author strugatskyA = new Author("Аркадий Натанович Стругацкий", LocalDate.of(1925, 8, 28), LocalDate.of(1991, 10, 12), Author.Gender.male);
        Author strugatskyB = new Author("Борис Натанович Стругацкий", LocalDate.of(1933, 4, 15), LocalDate.of(2012, 11, 9), Author.Gender.male);
        Author efremov = new Author("Иван Антонович Ефремов", LocalDate.of(1908, 4, 22), LocalDate.of(1972, 10, 5), Author.Gender.male);
        Author gitkovich = new Author("Вадим Константинович Гиткович", LocalDate.of(1924, 7, 6), LocalDate.of(1977, 10, 28), Author.Gender.male);
        Author pualo = new Author("Пуало Коэльо", LocalDate.of(1947, 8, 24), Author.Gender.male);
        Book nichegoNet = new Book("Ничего нет прекрасней Земли...", 1968, Arrays.asList(strugatskyA, efremov));
        Book lezvie = new Book("Лезвие бритвы", 1964, Arrays.asList(efremov));
        Book prognoz = new Book("Прогноз", 1989, Arrays.asList(strugatskyA, strugatskyB));
        Book dyavol = new Book("Дьявол среди людей", 1991, Arrays.asList(strugatskyA, strugatskyB));
        Book strana = new Book("Страна Фантазия", 1970, Arrays.asList(efremov, gitkovich));
        Book alchimik = new Book("Алхимик", 1988, Arrays.asList(pualo));
        authors.add(strugatskyA);
        authors.add(strugatskyB);
        authors.add(efremov);
        authors.add(gitkovich);
        authors.add(pualo);
        books.add(nichegoNet);
        books.add(lezvie);
        books.add(prognoz);
        books.add(dyavol);
        books.add(strana);
        books.add(alchimik);
    }
}
