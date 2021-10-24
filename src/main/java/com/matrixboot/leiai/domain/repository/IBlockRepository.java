package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.domain.BlockTypeEnum;
import com.matrixboot.leiai.domain.entity.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>
 * create in 2021/10/21 4:13 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IBlockRepository extends JpaRepository<BlockEntity, Long> {

    /**
     * 根据 TYPE 和 VALUE 类型查找
     *
     * @param type  类型
     * @param value 值
     * @return BlockEntity
     */
    BlockEntity findByTypeAndValue(BlockTypeEnum type, String value);

    /**
     * 更新点赞数量
     *
     * @param id id
     */
    @Modifying
    @Query("UPDATE BlockEntity block SET block.agreement = block.agreement + 1")
    void updateAgreement(long id);

}
