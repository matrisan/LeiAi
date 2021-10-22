package com.matrixboot.leiai.domain.repository;

import com.matrixboot.leiai.domain.entity.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * create in 2021/10/21 4:13 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
public interface IBlockRepository extends JpaRepository<BlockEntity, Long> {
}
