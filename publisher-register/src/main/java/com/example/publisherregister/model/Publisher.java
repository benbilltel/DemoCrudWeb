package com.example.publisherregister.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Publisher",uniqueConstraints = {
        @UniqueConstraint(name = "fk_pb_name",columnNames = "name")
})
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,
    columnDefinition = "TEXT"
    )
    private String name;

    @Column(nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
//    @Transient
    private Integer published;

    public Publisher(Long id, String name, String email, Integer published) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.published = published;
    }

    public Publisher() {
    }

    public Publisher(String name, String email, Integer published) {
        this.name = name;
        this.email = email;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", published=" + published +
                '}';
    }
}
