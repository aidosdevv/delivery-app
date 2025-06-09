package kz.deliver.deliver_mobile_app.mapper;

import kz.deliver.deliver_mobile_app.dto.DriverDto;
import kz.deliver.deliver_mobile_app.models.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverDto toDto(Driver driver);
    Driver toEntity(DriverDto driverDto);
    

}
