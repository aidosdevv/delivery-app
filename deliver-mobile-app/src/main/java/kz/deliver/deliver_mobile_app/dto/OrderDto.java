package kz.deliver.deliver_mobile_app.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private String name;
    private int price;
    private String from;
    private String to;
    private String description;

    private Long customerId;
    private Long driverId;
}
