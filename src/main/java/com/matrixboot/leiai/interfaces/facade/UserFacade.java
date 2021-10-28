package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.application.LoginCommand;
import com.matrixboot.leiai.application.service.UserService;
import com.matrixboot.leiai.infrastructure.common.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 * create in 2021/10/27 8:51 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class UserFacade {

    @Resource
    private UserService userService;

    @PostMapping("login")
    public ResultVO<Void> login(@RequestBody LoginCommand command) {
        userService.checkUser(command);
        return ResultVO.success();
    }
}
