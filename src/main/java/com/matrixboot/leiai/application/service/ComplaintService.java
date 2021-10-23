package com.matrixboot.leiai.application.service;

import com.matrixboot.leiai.application.ComplaintCommand;
import com.matrixboot.leiai.application.ComplaintFactory;
import com.matrixboot.leiai.domain.entity.BlockEntity;
import com.matrixboot.leiai.domain.repository.IBlockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 投诉板块
 * <p>
 * create in 2021/10/23 2:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@AllArgsConstructor
@Service
public class ComplaintService {

    private final IBlockRepository blockRepository;

    /**
     * 举报模块
     *
     * @param command 举报模块
     */
    public void complaint(ComplaintCommand command) {
        BlockEntity from = ComplaintFactory.from(command);
        blockRepository.save(from);
    }

    /**
     * 举报查询模块
     */
    void lookupSuspicious() {

    }

}
