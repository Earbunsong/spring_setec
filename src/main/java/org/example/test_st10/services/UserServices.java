package org.example.test_st10.services;

import org.example.test_st10.dto.UserResponse;
import org.example.test_st10.dto.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface UserServices {

    UserResponse create(UserRequest userRequest);
    UserResponse update(Long id, UserRequest userRequest);
    UserResponse findById(Long id);
    void delete(Long id);
    List<UserResponse> findAll();
}
