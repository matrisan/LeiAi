package com.matrixboot.leiai.application.service;

import com.matrixboot.leiai.application.LoginCommand;
import com.matrixboot.leiai.application.UserFactory;
import com.matrixboot.leiai.application.WeChatResponse;
import com.matrixboot.leiai.domain.entity.UserInfoEntity;
import com.matrixboot.leiai.domain.repository.IUserInfoRepository;
import com.matrixboot.leiai.infrastructure.config.WeChatProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * create in 2021/10/27 10:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@AllArgsConstructor
@Service
public class UserService {

    private final RestTemplate restTemplate;

    private final WeChatProperties properties;

    private final IUserInfoRepository userInfoRepository;

    public void checkUser(LoginCommand command) {
        WeChatResponse template = restTemplate.getForObject(properties.requestUrl(command), WeChatResponse.class);
        if (!Objects.isNull(template) && !userInfoRepository.existsByOpenId(template.getOpenId())) {
            UserInfoEntity entity = UserFactory.from(template);
            userInfoRepository.save(entity);
        }
    }
}
