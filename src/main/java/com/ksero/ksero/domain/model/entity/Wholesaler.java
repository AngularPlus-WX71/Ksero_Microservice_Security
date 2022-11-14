package com.ksero.ksero.domain.model.entity;

import com.ksero.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Entity
@Table(name = "wholesaler")
public class Wholesaler extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String birthday;

    @NotNull
    private String phone;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    private String address;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    private String description;

}
