package com.ecommerce.library.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryPersonDto {
    @Size(min = 3, max = 10, message = "First name contains 3-10 characters")
    private String firstName;
    @Size(min = 3, max = 10, message = "Last name contains 3-10 characters")
    private String lastName;
    private String username;
    @Size(min = 3, max = 15, message = "Password contains 3-10 characters")
    private String password;
    private String phoneNumber;
    private String address;
    private String confirmPassword;
}