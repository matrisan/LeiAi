package com.matrixboot.leiai.application;

import com.matrixboot.leiai.domain.entity.UserInfoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * <p>
 * create in 2021/10/27 10:35 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserFactory {

    public static UserInfoEntity from(WeChatResponse response) {
        return UserInfoEntity.builder()
                .openId(response.getOpenId())
                .sessionKey(response.getSessionKey())
                .build();
    }

}
