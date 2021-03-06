package jh.hierarchies.tableperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@Builder
@DiscriminatorValue("fiction")
@Entity
@Table(name = "per_table_fiction_book", schema = "hierarchies")
public class FictionBook extends Book {
    private String genre;
    @Column(name = "is_poem")
    private Boolean isPoem;
}
