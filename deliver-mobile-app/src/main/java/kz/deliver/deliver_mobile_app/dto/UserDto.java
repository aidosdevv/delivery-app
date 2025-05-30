package kz.deliver.deliver_mobile_app.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    private int age;

    private boolean is_enabled = false;

    private int orders = 0;
}
