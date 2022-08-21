package com.noman.dialogues;

public class StudentModel {
    String id;
    String registration_no;
    String name;
    String created_at;

    public StudentModel() {
        this.id = "";
        this.registration_no = "";
        this.name = "";
        this.created_at = "";
    }

    public StudentModel(String id, String registration_no, String name, String created_at) {
        this.id = id;
        this.registration_no = registration_no;
        this.name = name;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getRegistration_no_no() {
        return registration_no;
    }

    public String getName() {
        return name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReg_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
