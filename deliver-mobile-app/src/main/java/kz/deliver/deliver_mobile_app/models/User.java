package kz.deliver.deliver_mobile_app.models;

import jakarta.persistence.*;
import lombok.*;

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

    private boolean is_enabled = false;

    private int orders = 0;

}
