package ro.itschool.homework.service;

import org.springframework.stereotype.Service;
import ro.itschool.homework.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final List<User> USERS = new ArrayList<>();

    public static List<User> getUSERS() {
        return USERS;
    }

    public void addUser(User user){
        USERS.add(user);
    }

    public User getUserById(int id){
        return USERS.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateUser(User user, User existingUser){
        if(user.getFirstName() != null){
            existingUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null){
            existingUser.setLastName(user.getLastName());
        }
        if(user.getSSN() != 0){
            existingUser.setSSN(user.getSSN());
        }

    }

    public void replaceUser(User user, User existingUser){
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setSSN(user.getSSN());
    }

    public void deleteUserById(int id){
        USERS.removeIf(u -> u.getId() == id);
    }


}
