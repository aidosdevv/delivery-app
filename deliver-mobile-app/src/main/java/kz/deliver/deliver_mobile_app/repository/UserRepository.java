package kz.deliver.deliver_mobile_app.repository;

import kz.deliver.deliver_mobile_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
