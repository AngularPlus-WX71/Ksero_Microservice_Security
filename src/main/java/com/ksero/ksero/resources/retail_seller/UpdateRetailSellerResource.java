package com.ksero.ksero.resources.retail_seller;

import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRetailSellerResource {

    private Long id;
    private String firstName;
    private String address;
    private String lastName;
    private String birthday;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String description;
    private String paymentName;
    private String paymentPhone;
    private String paymentEmail;
    private String paymentCardNumber;
    private String paymentExpirationDate;
    private String paymentCVV;
}
