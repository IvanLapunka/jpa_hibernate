package jh.other;


import jh.relations.AbstractEntity;
import jh.relations.Zoo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Director extends AbstractEntity {
    @Column
    private String title;
    @Column
    private String fullName;
    @Column
    private Integer salary;
    private Zoo zoo;
}
