package sungdong29.backend.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByNickname(String nickname);
    Optional<User> findByUsername(String username);
}




