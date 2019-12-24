package com.example.factory;

import com.example.entity.User;
import com.example.repository.impl.GoogleDriveUserRepositoryImpl;
import com.example.repository.impl.InMemoryUserRepositoryImpl;
import com.example.repository.impl.MySQLUserRepositoryImpl;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.util.UserDBUtil;
import com.example.util.UserGoogleDriveUtil;

import java.util.Map;

/**
 * Factory class for UserService
 */
public class UserServiceFactory {
    private Map<Long, User> userMap;

    public UserServiceFactory(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    public Map<Long, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    /**
     * Factory method for UserService
     *
     * @param sourceType
     * @return
     */
    public UserService getUserService(String sourceType) {
        UserService userService = null;
        MemoryType memoryType = MemoryType.getMemoryType(sourceType);
        switch (memoryType) {
            case INMEMORY:
                userService = new UserServiceImpl(new InMemoryUserRepositoryImpl(userMap, 0));
                break;
            case MYSQL:
                userService = new UserServiceImpl(new MySQLUserRepositoryImpl(new UserDBUtil()));
                break;
            case GOOGLE_DRIVE:
                userService = new UserServiceImpl(new GoogleDriveUserRepositoryImpl(new UserGoogleDriveUtil()));
                break;
            case UNKNOWN:
                System.out.println("No match UserServiceImpl");
        }
        return userService;
    }

}
