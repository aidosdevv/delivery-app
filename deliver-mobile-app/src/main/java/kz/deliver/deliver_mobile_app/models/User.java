package kz.deliver.deliver_mobile_app.models;

import jakarta.persistence.*;
import kz.deliver.deliver_mobile_app.enums.Role;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private int age;

    private boolean enabled = false;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "customer")
    private List<Order> madeOrders;

    @OneToMany(mappedBy = "driver")
    private List<Order> takenOrders;
}
