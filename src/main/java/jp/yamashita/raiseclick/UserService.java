package jp.yamashita.raiseclick;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getUserDetails(Long id){
        User user =userRepository.findById(id);
        if(user != null){
            user.setName(user.getName().toUpperCase());
        }
        return user;
    }
}
