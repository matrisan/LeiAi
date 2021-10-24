package com.matrixboot.leiai.application.service;

import com.matrixboot.leiai.application.ComplaintCommand;
import com.matrixboot.leiai.application.ComplaintFactory;
import com.matrixboot.leiai.application.ComplaintQuery;
import com.matrixboot.leiai.domain.entity.BlockEntity;
import com.matrixboot.leiai.domain.repository.IBlockRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Transient;
import javax.validation.Valid;
import java.util.Optional;

/**
 * 投诉板块
 * <p>
 * create in 2021/10/23 2:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Service
@Validated
@AllArgsConstructor
public class ComplaintService {

    private final IBlockRepository blockRepository;

    /**
     * 举报模块
     *
     * @param command 举报模块
     */
    public void complaint(@Valid ComplaintCommand command) {
        BlockEntity from = ComplaintFactory.from(command);
        blockRepository.save(from);
    }

    /**
     * 举报查询模块
     *
     * @param query 查询条件
     * @return 查询结果
     */
    public BlockEntity lookupSuspicious(@NotNull ComplaintQuery query) {
        return blockRepository.findByTypeAndValue(query.getType(), query.getValue());
    }

    /**
     * 点赞
     *
     * @param id id
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean agreement(long id) {
        if (!blockRepository.existsById(id)) {
            return false;
        }
        blockRepository.updateAgreement(id);
        return true;
    }

}
