package com.example.kseromicroservicesecurity.security.domain.model.entity;

import com.example.kseromicroservicesecurity.security.domain.model.enumeration.Roles;
import com.example.kseromicroservicesecurity.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "roles")
public class Role extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Roles name;
}