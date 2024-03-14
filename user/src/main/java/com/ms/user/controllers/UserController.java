package com.ms.user.controllers;

import com.ms.user.dtos.UserRecord;
import com.ms.user.models.UserModel;
import com.ms.user.usecase.UserUseCaseMaintenance;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserUseCaseMaintenance userUseCaseMaintenance;

    public UserController(UserUseCaseMaintenance userUseCaseMaintenance) {
        this.userUseCaseMaintenance = userUseCaseMaintenance;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecord userRecord){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecord, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userUseCaseMaintenance.save(userModel));
    }

}
