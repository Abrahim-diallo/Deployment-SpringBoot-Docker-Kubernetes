package com.brahimcodester.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname", nullable = false)
    @NotBlank(message = "Le champ ne peut pas être vide")
    @NotNull(message = "Le champ ne peut pas être nul")
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$", message = "Le champ nom ne peut pas contenir de chiffres ou de caractères spéciaux")
    @Schema(description = "Nom de l'employé", example = "John")
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @NotBlank(message = "Le champ ne peut pas être vide")
    @NotNull(message = "Le champ ne peut pas être nul")
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$", message = "Le champ nom de famille ne peut pas contenir de chiffres ou de caractères spéciaux")
    @Schema(description = "Nom de famille de l'employé", example = "Doe")
    private String lastName;

    @Column(name = "age", nullable = false)
    @Positive(message = "Doit être positif et non nul")
    @NotNull(message = "Le champ ne peut pas être nul")
    @Schema(description = "Âge de l'employé", example = "30")
    private Integer age;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Le champ ne peut pas être vide")
    @NotNull(message = "Le champ ne peut pas être nul")
    @Email(message = "Le champ doit contenir un format d'adresse e-mail valide")
    @Schema(description = "Adresse e-mail de l'employé", example = "exemple@exemple.com")
    private String email;

    @Column(name = "cellphone", nullable = false)
    @NotBlank(message = "Le champ ne peut pas être vide")
    @NotNull(message = "Le champ ne peut pas être nul")
    @Pattern(regexp = "^[0-9()+\\-\\s]*$", message = "Le champ ne doit contenir que des chiffres, des parenthèses, des symboles plus ou moins, et des espaces.")
    @Schema(description = "Numéro de téléphone de l'employé", example = "+43 (X) 1234 56-789")
    private String cellphone;

    @Column(name = "gender", nullable = false)
    @NotNull(message = "Le champ ne peut pas être nul")
    @Enumerated(value = EnumType.STRING)
    @Schema(description = "Genre de l'employé", example = "HOMME")
    private Gender gender;

    @Column(name = "dni", nullable = false)
    @NotBlank(message = "Le champ ne peut pas être vide")
    @NotNull(message = "Le champ ne peut pas être nul")
    @Pattern(regexp = "^[0-9]{7,8}$", message = "Le champ DNI (Document National d'Identité) doit contenir 7 ou 8 chiffres numériques.")
    @Schema(description = "DNI (Document National d'Identité) de l'employé", example = "12345678 ou 1234567")
    private String dni;
}
