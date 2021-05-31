package com.company.LibraryApplicationWithSpringMVC.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "userBookList")
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "budget")
    private Float budget;

    public User(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserBook> userBookList;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private com.company.LibraryApplicationWithSpringMVC.models.Role role;


}
