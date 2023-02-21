package com.sanchi.controllerdemo;

import java.util.UUID;

public class Grade {

    private String name;
    private String sub;
    private String score;
    private String id;

    public Grade(String name, String sub, String score) {
        this.name = name;
        this.sub = sub;
        this.score = score;
        
    }

    public Grade() {
        this.id = UUID.randomUUID().toString();
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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
