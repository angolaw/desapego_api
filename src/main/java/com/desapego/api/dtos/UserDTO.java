package com.desapego.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Data
public class UserDTO {

    Long id;
    @Size(min = 2, message = "Nome deve ter pelo menos 2 caracteres")
    String name;
    @Email(message = "Email deve ser válido")
    String email;
    @Size(min=11, message = "Telefone deve ser informado no padrão DDD9xxxxxxxx")
    String telephoneNumber;
}
