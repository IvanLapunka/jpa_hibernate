package org.jpwh.model.helloworld;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
public class Message {
    @Id
    @GeneratedValue//automatic generation of IDs
    private Long id;
    private String text;
}
