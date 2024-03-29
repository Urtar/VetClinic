package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Admin;

@Repository
@Transactional
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByLogin(String login);
}
