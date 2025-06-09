package kz.deliver.deliver_mobile_app.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private String name;
    private int price;
    private String from;
    private String to;
    private String description;
}
