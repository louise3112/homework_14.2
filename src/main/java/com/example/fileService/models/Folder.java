package com.example.fileService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    @JsonBackReference
    private Person person;

    @OneToMany (mappedBy = "folder")
    private List<File> files;

    public Folder() {}

    public Folder(String title, Person person) {
        this.title = title;
        this.person = person;
        this.files = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
