package com.sanchi.controllerdemo;

public class Grade {

    private String name;
    private String sub;
    private String score;

    public Grade(String name, String sub, String score) {
        this.name = name;
        this.sub = sub;
        this.score = score;
    }

    public Grade() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return this.sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", sub='" + getSub() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }

}
