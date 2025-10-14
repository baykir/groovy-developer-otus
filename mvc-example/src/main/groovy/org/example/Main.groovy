package org.example

import org.example.model.User
import org.example.service.UserManager
import org.example.store.UserService

static void main(String[] args) {
    UserService userService = new UserService()

    User admin = new User(1, 'admin')
    User account = new User(2, 'account')
    User tuz = new User(3, 'tuz')

    println admin.getName()

    userService.save(admin)
    userService.save(account)
    userService.save(tuz)

    userService.getAllUsers().each {
        println(it.name)
    }

    println userService.getUserById(2).name

}