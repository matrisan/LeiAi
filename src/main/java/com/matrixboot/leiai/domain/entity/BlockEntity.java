package com.matrixboot.leiai.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

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
 * create in 2021/10/21 8:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@Entity
@Table(name = "BlockEntity")
public class BlockEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3005703108688072364L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    private Long id;


    private String name;
//    @Transient
//    private BlockValue value;

}
