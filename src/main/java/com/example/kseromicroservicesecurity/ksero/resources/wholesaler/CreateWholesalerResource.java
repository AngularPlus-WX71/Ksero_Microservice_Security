package com.example.kseromicroservicesecurity.ksero.resources.wholesaler;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateWholesalerResource {

    private String firstName;
    private String address;
    private String lastName;
    private String birthday;
    private String phone;
    private String email;
    private String username;
    private String password;
    private String description;
}
