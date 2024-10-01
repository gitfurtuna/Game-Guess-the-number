package org.example;

public class User {
    protected int id;
    protected String gender;
    protected String name;
    protected int bestScore;

    protected User (String gender, String name) {
    this.id = UserIdsGenerator.getInstance().generateId();
    this.gender = gender;
    this.name = name;
    this.bestScore = 0;
    }

}
