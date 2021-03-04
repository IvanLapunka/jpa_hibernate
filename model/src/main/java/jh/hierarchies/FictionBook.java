package jh.hierarchies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@Table(name = "fiction_book", schema = "hierarchies")
@Builder
public class FictionBook extends Book{
    private String genre;
    @Column(name = "is_poem")
    private Boolean isPoem;
}
