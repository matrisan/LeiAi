package com.matrixboot.leiai.domain.entity;

import com.matrixboot.leiai.domain.BlockTypeEnum;
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "block_entity", uniqueConstraints = {@UniqueConstraint(name = "uk_type_value", columnNames = {"type", "value"})})
public class BlockEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3005703108688072364L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    private Long id;

    /**
     * 查询的类型
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, columnDefinition = "TINYINT COMMENT '举报类型'")
    private BlockTypeEnum type;

    /**
     * 值
     */
    @Column(nullable = false, columnDefinition = "VARCHAR(20) COMMENT '投诉的字段'")
    private String value;

    /**
     * 描述
     */
    @Column(columnDefinition = "VARCHAR(50) COMMENT '投诉的描述'")
    private String description;

    /**
     * 有多少人看过
     */
    @Column(columnDefinition = "BIGINT COMMENT '有多少人看过'")
    private Long glimpse;

    /**
     * 举报次数
     */
    @Column(columnDefinition = "BIGINT COMMENT '举报次数'")
    private Long complaint;

    /**
     * 有多少人点过赞
     */
    @Column(columnDefinition = "BIGINT DEFAULT 0 COMMENT '点赞数'")
    private Long agreement;

}
