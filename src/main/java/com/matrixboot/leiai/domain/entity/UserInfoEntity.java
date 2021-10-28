package com.matrixboot.leiai.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * <p>
 * create in 2021/10/23 2:05 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user_info_entity", uniqueConstraints = {@UniqueConstraint(name = "uk_openid", columnNames = {"open_id"})})
public class UserInfoEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8033727963135202120L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    private Long id;

    @Column(name = "open_id",columnDefinition = "VARCHAR(100) COMMENT 'address'")
    private String openId;

    @Column(name = "nick_name",columnDefinition = "VARCHAR(50) COMMENT 'nickName'")
    private String nickName;

    @Column(columnDefinition = "TINYINT COMMENT 'address'")
    private Integer gender;

    @Column(columnDefinition = "VARCHAR(20) COMMENT 'city'")
    private String city;

    @Column(columnDefinition = "VARCHAR(20) COMMENT 'country'")
    private String country;

    @Column(columnDefinition = "VARCHAR(10) COMMENT 'language'")
    private String language;

    @Column(name = "session_key",columnDefinition = "VARCHAR(100) COMMENT 'address'")
    private String sessionKey;

    @Column(name = "avatar_url",columnDefinition = "VARCHAR(200) COMMENT 'address'")
    private String avatarUrl;

}
