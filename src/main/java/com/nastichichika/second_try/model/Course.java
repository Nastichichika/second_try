package com.nastichichika.second_try.model;

import javax.persistence.*;
/*
{
   "title": "Math for 1 class",
   "text":"I like math",
   "theme":"Math"
}
{
        "title": "Ukraine for 11 class",
        "text": "Shevchenko ",
        "theme": "Ukr_lit"
    }
*/
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "theme")
    private String theme;

    @Column(name = "idteacher")
    private int idteacher;


    public Course(String title, String theme, String text) {
        this.title = title;
        this.theme = theme;
        this.text = text;
    }

    public Course() {

    }

    public int getId_teacher() {
        return idteacher;
    }

    public void setId_teacher(int id_teacher) {
        this.idteacher = id_teacher;
    }

    public Course(String title, String text, String theme, int id_teacher) {
        this.title = title;
        this.text = text;
        this.theme = theme;
        this.idteacher = id_teacher;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
