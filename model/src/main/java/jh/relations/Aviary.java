package jh.relations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aviary", schema = "relations")
public class Aviary extends AbstractEntity {
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "aviary_id")
    private Set<Animal> animals;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "aviary_worker",
            schema = "relations",
            joinColumns = {@JoinColumn(name = "aviary_id")},
            inverseJoinColumns = {@JoinColumn(name = "worker_id")}
    )
    private Set<ZooWorker> workers;

    @ManyToOne
    private Zoo zoo;
}
