package com.matrixboot.leiai.domain.entity;

import com.matrixboot.leiai.domain.BlockValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * <p>
 * create in 2021/10/21 8:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Entity
public class BlockEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    private Long id;

    @Transient
    private BlockValue value;

}
