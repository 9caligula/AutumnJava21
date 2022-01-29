package com.netcracker.myProject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "attributes")
public class AttributeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String name;

    @NonNull
    @ManyToOne()
    @JoinColumn(name = "objectTypeId", referencedColumnName = "id")
    ObjectTypeEntity objectType;

    public static AttributeEntity makeDefault(ObjectTypeEntity objectType, String name) {
        return builder()
                .name(name)
                .objectType(objectType)
                .build();
    }
}