package com.omoniyi.codetest.interview.service;

import com.omoniyi.codetest.interview.dto.UserDTO;
import com.omoniyi.codetest.interview.entity.User;

import java.util.List;

/**
 * @author OMONIYI ILESANMI
 */
public interface UserService {

    List<UserDTO> getUser();
 }
