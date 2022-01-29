package com.netcracker.myProject.entity;

import com.netcracker.myProject.repository.ObjectTypeRepository;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "objects")
public class ObjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "objectTypeId", referencedColumnName = "id")
    ObjectTypeEntity objectType;

    public static ObjectEntity makeDefault(ObjectTypeEntity objectType, String name) {
        return builder()
                .name(name)
                .objectType(objectType)
                .build();
    }
}