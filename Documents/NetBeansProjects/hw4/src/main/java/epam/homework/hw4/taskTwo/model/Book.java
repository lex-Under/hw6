package epam.homework.hw4.taskTwo.model;

import java.time.LocalDate;
import java.util.List;

public class Book {

    private String name;
    private int publishedYear;
    private List<Author> authors;

    public Book(String name, int year, List<Author> authors) {
        this.name = name;
        this.publishedYear = year;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getAge() {
        return LocalDate.now().getYear() - this.publishedYear;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("name: " + name + ",\nyear of publiсation: " + publishedYear + ",\n since publiсation: " + getAge() + " years,\n authors: ");
        for (Author a : getAuthors()) {
            s.append(a.getName()).append("; ");
        }
        return s.toString();
    }
    /*
    @Override
    public int hashCode(){
        return name.hashCode() + authors.hashCode();
    }
*
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Book)) return false;
        return o.hashCode()==this.hashCode();
    }
     */
}
