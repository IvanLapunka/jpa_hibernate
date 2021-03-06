package jh.hierarchies.mapped;

import jh.hierarchies.mapped.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@Table(name = "science_book", schema = "hierarchies")
@Builder
public class ScienceBook extends Book {
    private String science;

}
