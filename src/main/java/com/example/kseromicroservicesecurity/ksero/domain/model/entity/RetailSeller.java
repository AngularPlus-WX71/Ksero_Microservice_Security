package com.example.kseromicroservicesecurity.ksero.domain.model.entity;

import com.example.kseromicroservicesecurity.shared.domain.model.AuditModel;
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
@Table(name = "retail_seller")
public class RetailSeller extends AuditModel {
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

    @NotNull
    private String paymentName;
    @NotNull
    private String paymentPhone;
    @NotNull
    private String paymentEmail;
    @NotNull
    private String paymentCardNumber;
    @NotNull
    private String paymentExpirationDate;
    @NotNull
    private String paymentCVV;
}
