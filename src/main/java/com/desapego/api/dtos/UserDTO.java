package com.desapego.api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class UserDTO {
    @JsonIgnore
    Long id;
    @Size(min = 2, message = "Nome deve ter pelo menos 2 caracteres")
    @NotBlank
    String name;
    @Email(message = "Email deve ser válido")
    @NotBlank
    String email;
    @Size(min=11, message = "Telefone deve ser informado no padrão DDD9xxxxxxxx")
    @NotBlank
    String telephoneNumber;
}
