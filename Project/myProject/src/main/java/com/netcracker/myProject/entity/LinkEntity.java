package com.netcracker.myProject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "link")
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    @OneToOne
    @JoinColumn(name = "objectId", referencedColumnName = "id")
    ObjectEntity objectEntity;

    @NonNull
    @ManyToOne()
    @JoinColumn(name = "attributeId", referencedColumnName = "id")
    AttributeEntity attributeEntity;

    @NonNull
    @OneToOne
    @JoinColumn(name = "referenceId", referencedColumnName = "id")
    ObjectEntity reference;

    public static LinkEntity makeDefault(ObjectEntity object, ObjectEntity referenceObj, AttributeEntity attribute) {
        return builder()
                .attributeEntity(attribute)
                .objectEntity(object)
                .reference(referenceObj)
                .build();
    }
}
