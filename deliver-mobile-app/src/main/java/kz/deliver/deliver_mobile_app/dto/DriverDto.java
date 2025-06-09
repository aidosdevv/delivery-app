package kz.deliver.deliver_mobile_app.dto;

import jakarta.persistence.OneToMany;
import kz.deliver.deliver_mobile_app.models.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DriverDto {

    private Long id;
    private String name;
    private String phone;
    private String licenseNumber;
}
