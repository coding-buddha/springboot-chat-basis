package edu.pasudo123.study.demo.chat.storage;

import edu.pasudo123.study.demo.chat.exception.UserAddException;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

    private static UserStorage instance;
    private final Set<String> users = new HashSet<>();

    private UserStorage() {}

    public static synchronized UserStorage getInstance(){
        if(instance == null) {
            instance = new UserStorage();
        }

        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void addUserName(final String userName){
        if(users.contains(userName)){
            throw new UserAddException("해당 유저는 현재 존재하고 있습니다. : {}", userName);
        }

        this.users.add(userName);
    }
}
