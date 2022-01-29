package com.netcracker.myProject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "parameters")
public class ParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String value;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "objectId", referencedColumnName = "id")
    ObjectEntity objectEntity;

    @NonNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "attributeId", referencedColumnName = "id")
    AttributeEntity attributeEntity;

    public static ParameterEntity makeDefault(ObjectEntity objectEntity, AttributeEntity attribute, String value) {
        return builder()
                .value(value)
                .objectEntity(objectEntity)
                .attributeEntity(attribute)
                .build();
    }
}
