package kz.deliver.deliver_mobile_app.dto;

import kz.deliver.deliver_mobile_app.enums.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private int age;
    private boolean enabled;
    private Role role;
    private List<OrderDto> orders;
}
