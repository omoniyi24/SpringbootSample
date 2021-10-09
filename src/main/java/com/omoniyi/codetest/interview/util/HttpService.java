package com.omoniyi.codetest.interview.util;

import com.omoniyi.codetest.interview.dto.UserDTO;
import com.omoniyi.codetest.interview.entity.User;
import com.omoniyi.codetest.interview.web.rest.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author OMONIYI ILESANMI
 */

@Component
public class HttpService {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final RestTemplate restTemplate;

    @Value("${app.thirdparty.user.url}")
    private String userDetailsUrl;

    public HttpService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object makeGetRequestCall(){
        log.info("calling {} ", userDetailsUrl);
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(userDetailsUrl, Object.class);
        log.info("thirdParty raw respose {} ", responseEntity);
        return responseEntity.getBody();
    }
}
