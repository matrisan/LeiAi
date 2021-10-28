package com.matrixboot.leiai.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <p>
 * create in 2021/10/27 10:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class WeChatResponse {

    @JsonProperty("session_key")
    private String sessionKey;

    @JsonProperty("openid")
    private String openId;

}
