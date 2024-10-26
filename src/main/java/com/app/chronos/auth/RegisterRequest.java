package com.app.chronos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @Size(min = 6, message = "El nombre de usuario debe tener al menos 6 caracteres.")
    private String username;

    @Email(message = "El correo electrónico no es válido.")
    private String email;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).+$", 
            message = "La contraseña debe contener al menos una letra mayúscula y un número.")
    private String password;
}
