package jh.hierarchies.join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@Builder
@DiscriminatorValue("science")
@Entity
@Table(name = "join_science_book", schema = "hierarchies")
public class ScienceBook extends Book {
    private String science;

}
