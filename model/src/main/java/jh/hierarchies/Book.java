package jh.hierarchies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@MappedSuperclass
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "publish_year")
    private int publishYear;
    private String author;
    @Column(name = "title")
    private String bookTitle;
}
