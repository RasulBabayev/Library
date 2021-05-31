package com.company.LibraryApplicationWithSpringMVC.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_book")
public class UserBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private com.company.LibraryApplicationWithSpringMVC.models.User user;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private com.company.LibraryApplicationWithSpringMVC.models.Book book;
}
