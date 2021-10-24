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

/**
 * <p>
 * create in 2021/10/21 4:31 下午
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
@Table(name = "periodical_entity", uniqueConstraints = {@UniqueConstraint(name = "uk_recid", columnNames = {"rec_id"})})
public class PeriodicalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT COMMENT 'id'")
    private Long id;

    @Column(name = "rec_id", columnDefinition = "VARCHAR(50) COMMENT 'recId'")
    private String recId;

    @Column(name = "org_type", columnDefinition = "VARCHAR(50) COMMENT 'orgType'")
    private String orgType;

    @Column(name = "host_unit", columnDefinition = "VARCHAR(50) COMMENT 'hostUnit'")
    private String hostUnit;

    @Column(columnDefinition = "VARCHAR(50) COMMENT 'address'")
    private String address;

    @Column(columnDefinition = "VARCHAR(50) COMMENT 'station'")
    private String station;

    @Column(name = "org_name", columnDefinition = "VARCHAR(50) COMMENT 'orgName'")
    private String orgName;

    @Column(name = "charge_unit", columnDefinition = "VARCHAR(50) COMMENT 'chargeUnit'")
    private String chargeUnit;

    @Column(columnDefinition = "VARCHAR(50) COMMENT 'language'")
    private String language;

    @Column(name = "org_cn", columnDefinition = "VARCHAR(50) COMMENT 'orgCn'")
    private String orgCn;

    @Column(name = "link_num", columnDefinition = "VARCHAR(50) COMMENT '投诉的描述'")
    private String linkNum;

    @Column(columnDefinition = "BIGINT  DEFAULT 0  COMMENT '有多少人看过'")
    private Long glimpse;

}
