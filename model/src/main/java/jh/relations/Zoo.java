package jh.relations;

import jh.other.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "zoo", schema = "relations")
public class Zoo extends AbstractEntity {
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "zoo_id")
    private Set<Aviary> aviaries;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "zoo_id")
    private Set<ZooWorker> workers;
}
