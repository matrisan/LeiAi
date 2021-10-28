package com.matrixboot.leiai.infrastructure.config;

import cn.hutool.core.text.StrFormatter;
import com.matrixboot.leiai.application.LoginCommand;
import lombok.Data;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * create in 2021/10/27 10:14 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@Component
@ConfigurationProperties("spring.wechat")
public class WeChatProperties {

    private String url;

    private String appId;

    private String appSecret;

    private String grantType;

    @NotNull
    @Contract(pure = true)
    private String requestUrl() {
        return url + "?appid=" + appId + "&secret=" + appSecret + "&js_code={}&grant_type=" + grantType;
    }

    public String requestUrl(String code) {
        return StrFormatter.format(requestUrl(), code);
    }

    public String requestUrl(LoginCommand command) {
        return StrFormatter.format(requestUrl(), command.getCode());
    }

}
