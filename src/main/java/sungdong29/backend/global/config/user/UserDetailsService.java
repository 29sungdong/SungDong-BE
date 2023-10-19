package sungdong29.backend.global.config.user;


import sungdong29.backend.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDetailsService")
@RequiredArgsConstructor
public class UserDetailsService {


    @Transactional
    public UserDetails loadUserByUsername(Long id) throws UsernameNotFoundException {
//        return userRepository
//                .findById(id)
//                .map(user -> createUser(id, user))
//                .orElseThrow(() -> new UsernameNotFoundException(id + " -> DB에서 찾을 수 없음"));
        return null;
    }

    private UserDetails createUser(Long id, User user) {
        return new UserDetails(user);
    }
}
