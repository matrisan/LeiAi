package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.domain.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * create in 2021/10/23 2:06 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

    boolean existsByOpenId(String openId);

}
