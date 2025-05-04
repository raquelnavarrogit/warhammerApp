package TFG.TFG.services;

import TFG.TFG.models.User;
import TFG.TFG.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /*
     Get all users.
     */
    public List<User> getAll(){
        return userRepository.findAll();
    }

    /*
     Get one user by email and password.
     */
    public User findByEmailAndPassword(String email, String password){

        User user = null;

        if (email != null || password != null){
            user = userRepository.findByEmailAndPassword(email, password);
        }else if ( user != null){
            return userRepository.findByEmailAndPassword(email, password);
        }else{
            throw new NullPointerException("The user was not found.");
        }

        return user;
    }

    public User findByUsernameAndPassword(String username, String password){
        User user = null;

        if (username != null || password != null){
            user = userRepository.findByUsernameAndPassword(username, password);
        }else if ( user != null){
            return userRepository.findByUsernameAndPassword(username, password);
        }else{
            throw new NullPointerException("The user was not found.");
        }

        return user;
    }

    /*
    Get one user by email.
     */
    public User findById (String email){
        Optional<User> user = userRepository.findById(email);
        if (user.isPresent()){
            return user.get();
        }else{
            throw new NullPointerException("The user was not found.");
        }
    }

    /*
    Save a user in the database if it doesn't exist or update it if it does.
     */
    public void save(User user){
        if (user != null){
            userRepository.save(user);
        }else{
            throw new NullPointerException("The user was not found.");
        }
    }

    /*
    Delete a user from the database.
     */
    public void delete(User user){
        if (user != null){
            userRepository.delete(user);
        }else{
            throw new NullPointerException("The user was not found.");
        }
    }
}
