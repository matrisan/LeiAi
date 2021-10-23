package com.matrixboot.leiai.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
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
@MappedSuperclass
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user_info_entity")
public class UserInfoEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8033727963135202120L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    private Long id;


}
