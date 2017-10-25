package epam.homework.hw4.taskOne;

import epam.homework.hw4.taskOne.entities.GroupByMarkbook;
import epam.homework.hw4.taskOne.entities.Student;
import java.util.ArrayList;

public class DemoTaskOne {

    private ArrayList<Student> students = new ArrayList<>();
    private Injector injector = new Injector();
    private CacheFiller filler = new CacheFiller();

    public void launch() {
        init();
        GroupByMarkbook gr = new GroupByMarkbook();
        injector.inject(gr);
        filler.fill(gr.getCacheByMarkbook(), students, "markbookNo", "name");
        filler.fill(gr.getCacheByPassport(), students, "passportNo", "name");
        int targetMarkbook = 1922;
        int targetPassport = 5925;
        System.out.println("Студент по номеру зачётки " + targetMarkbook + ":");
        System.out.println(gr.getByMarkbook(1922) + "\n");
        System.out.println("Студент по номеру паспорта " + targetPassport + ":");
        System.out.println(gr.getByPassportNo(5925) + "\n");
    }

    private void init() {
        students.add(new Student("Иванов Дмитрий Иванович", 22, 6422, 1921, 4, "Информатика и вычислительная техника"));
        students.add(new Student("Пензина Евгения Константиновна", 22, 6423, 1922, 5, "Автоматизированные системы управления"));
        students.add(new Student("Болгов Артем Игоревич", 18, 6025, 575, 1, "Экономика и статистика"));
        students.add(new Student("Васильев Денис Филиппович", 17, 5925, 576, 1, "Экономика и статистика"));
        students.add(new Student("Горшкова Альбина Вартановна", 20, 6281, 1024, 2, "Прикладная математика"));
    }
}
