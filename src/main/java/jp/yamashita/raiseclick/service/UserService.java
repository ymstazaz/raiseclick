package jp.yamashita.raiseclick.service;

import jp.yamashita.raiseclick.model.User;
import jp.yamashita.raiseclick.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void createUser(User user){
        userRepository.insert(user);
    }
    public User getUserDetails(Long id){
        User user =userRepository.findById(id);
        if(user != null){
            user.setName(user.getName().toUpperCase());
        }
        return user;
    }
}
