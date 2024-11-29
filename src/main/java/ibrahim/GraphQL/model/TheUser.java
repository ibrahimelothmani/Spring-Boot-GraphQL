package ibrahim.GraphQL.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "the_user")

public class TheUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @JoinColumn(name = "name")
    private String name;
    @NotBlank
    @JoinColumn(name = "email")
    private String email;
    @NotBlank
    @JoinColumn(name = "password")
    private String password;
    @NotNull
    @Min(1990)
    @JoinColumn(name = "published_year")
    private int publishedYear;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();
}
