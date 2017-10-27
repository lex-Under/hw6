package epam.homework.hw4.taskOne;

import epam.homework.hw4.taskOne.entities.GroupByMarkbook;

public class DemoTaskOne {

    private Injector injector = new Injector();

    public void launch() {
        GroupByMarkbook gr = new GroupByMarkbook();
        injector.inject(gr);
        int targetMarkbook = 1922;
        int targetPassport = 5925;
        System.out.println("Студент по номеру зачётки " + targetMarkbook + ":");
        System.out.println(gr.getByMarkbook(1922) + "\n");
        System.out.println("Студент по номеру паспорта " + targetPassport + ":");
        System.out.println(gr.getByPassportNo(5925) + "\n");
    }

}
