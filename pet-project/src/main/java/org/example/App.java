package org.example;

public class App {
    public static void main(String[] args) {
        Boy boy = new Boy("boy", "Sergey");
        Girl girl = new Girl("girl", "Olesia");
        Details details = new Details();
        details.start(boy);
        details.start(girl);

    }
}
