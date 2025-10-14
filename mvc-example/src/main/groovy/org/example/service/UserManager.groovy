package org.example.service

import org.example.model.User
import org.example.store.UserService

class UserManager {
    UserService userService

    UserManager(UserService userService) {
        this.userService = userService
    }

    def addUser(User user) {
        userService.save(user)
    }

    def showSpecificUser(int id) {
        userService.getUserById(id)
    }

    def showAllUsers() {
        userService.getAllUsers()
    }
}
