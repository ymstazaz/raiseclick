package jp.yamashita.raiseclick.service;

import jp.yamashita.raiseclick.model.User;
import jp.yamashita.raiseclick.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByAddress(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with email: "+ username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getAddress())
                .password(user.getPassword())
                .roles(user.getRole().replace("ROLE_", ""))
                .build();
    }
}
