package com.omoniyi.codetest.interview.web.rest;

import com.omoniyi.codetest.interview.dto.UserDTO;
import com.omoniyi.codetest.interview.entity.User;
import com.omoniyi.codetest.interview.service.UserService;
import com.omoniyi.codetest.interview.util.ApplicationUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author OMONIYI ILESANMI
 */
@RestController
@RequestMapping(ApplicationUrl.BASE_CONTEXT_URL)
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(ApplicationUrl.GET_USERS)
    public ResponseEntity<List<UserDTO>> getUsers() {
        log.info("[+]Inside MeterController.getAllMeter with payload");
        List<UserDTO> users = userService.getUser();
        return ResponseEntity.ok().body(users);
    }
}
