package jh.relations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animal", schema = "relations")
@Access(AccessType.FIELD)
@NamedQueries(
        @NamedQuery(
                name = "get_animal_by_id",
                query = "select a from Animal a where a.id = :animal_id"
        )
)
public class Animal extends AbstractEntity{
    private String name;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "nick_name")
    private String nickName;

    public Animal(int id, String name, String groupName, String nickName) {
        super(id);
        this.name = name;
        this.groupName = groupName;
        this.nickName = nickName;
    }
}
