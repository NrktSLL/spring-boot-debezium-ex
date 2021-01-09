package com.nrkt.springbootdebeziumex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class User implements Serializable {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("second_name")
    String secondName;
    @NotBlank
    @JsonProperty("last_name")
    String lastName;
    @Email
    @JsonProperty("email")
    String email;
    @PastOrPresent
    @JsonProperty("born")
    Date born;

    @ToString.Exclude
    @Singular
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user")
    transient Set<Location> locations;
}
