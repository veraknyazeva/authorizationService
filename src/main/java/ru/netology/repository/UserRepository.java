package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.service.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String,Integer> userData = new HashMap<>();
    public List<Authorities> getUserAuthorities(String user, String password) {
        if(userData.containsKey(user) && userData.containsValue(password)){
            return new ArrayList<>(List.of(Authorities.values()));
        }
        return null;
    }
}
