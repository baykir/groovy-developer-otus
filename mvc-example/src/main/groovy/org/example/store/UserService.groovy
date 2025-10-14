package org.example.store

import org.example.model.User

class UserService {
    Map<Integer, User> users = new HashMap<>()
    int nextId = 1

    User save(User user) {
        user.setId(nextId++)
        users.put(user.getId(), user)
        return user
    }

    User getUserById(int id) {
        return users.get(id)
    }

    List<User> getAllUsers() {
        return new ArrayList<User>(users.values())
    }
}
