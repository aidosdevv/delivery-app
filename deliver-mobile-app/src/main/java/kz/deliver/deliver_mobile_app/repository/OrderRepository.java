package kz.deliver.deliver_mobile_app.repository;

import kz.deliver.deliver_mobile_app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
