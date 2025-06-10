package kz.deliver.deliver_mobile_app.models;

import jakarta.persistence.*;
import kz.deliver.deliver_mobile_app.enums.Role;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_users")
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private int age;

    private boolean enabled = false;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    private Role role;

}
