package com.omoniyi.codetest.interview.service.impl;

import com.omoniyi.codetest.interview.dto.UserDTO;
import com.omoniyi.codetest.interview.entity.User;
import com.omoniyi.codetest.interview.repository.UserRepository;
import com.omoniyi.codetest.interview.service.UserService;
import com.omoniyi.codetest.interview.util.HttpService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author OMONIYI ILESANMI
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HttpService httpService;

    public UserServiceImpl(UserRepository userRepository, HttpService httpService) {
        this.userRepository = userRepository;
        this.httpService = httpService;
    }


    @Override
    public List<UserDTO> getUser() {
        List<User> allUser = userRepository.findAll();
        if(allUser.isEmpty()){
            Object obj = httpService.makeGetRequestCall();
            return objToDTO(obj);
        }
        return toUserDTO(allUser);
    }

    private List<UserDTO> objToDTO(Object obj) {

        if (obj instanceof Collection<?>){
            List<User> users = new ArrayList<User>((Collection<? extends User>) obj);
            return users.stream().map(new Function<User, UserDTO>() {
                @Override
                public UserDTO apply(User user) {
                    UserDTO userDTO = new UserDTO();
                    BeanUtils.copyProperties(user, userDTO);
                    return userDTO;
                }
            }).collect(Collectors.toList());
        }
        return null;
    }

    private List<UserDTO> toUserDTO(List<User> users) {

        return users.stream().map(new Function<User, UserDTO>() {
            @Override
            public UserDTO apply(User user) {
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(user, userDTO);
                return userDTO;
            }
        }).collect(Collectors.toList());
    }
}
