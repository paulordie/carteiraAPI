package com.wallet.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    private Long id;
    @Email(message="Email inválido UserDTO")
    private String email;
    @Length(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres")
    private String name;
    @NotNull
    @Length(min=6, message="A senha deve conter o mínimo 6 caracteres")
    private String password;
}
