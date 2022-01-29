package com.netcracker.myProject.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "objectType")
public class ObjectTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String name;

    @ManyToOne
    @JoinColumn(name = "objectTypeParentId", referencedColumnName = "id")
    ObjectTypeEntity objectTypeParent;

    public static ObjectTypeEntity makeDefault(String type, ObjectTypeEntity parent) {
        return builder()
                .objectTypeParent(parent)
                .name(type)
                .build();
    }
}