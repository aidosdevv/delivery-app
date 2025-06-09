package kz.deliver.deliver_mobile_app.repository;

import kz.deliver.deliver_mobile_app.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
}
