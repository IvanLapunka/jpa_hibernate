package jh.relations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "worker", schema = "relations")
@Builder
public class ZooWorker extends AbstractEntity implements Serializable {

    @Column(name = "full_name")
    private String fullName;
    private Integer salary;

    @ManyToMany(mappedBy = "workers")
    private Set<Aviary> aviaries;

    @ManyToOne
    private Zoo zoo;
}
