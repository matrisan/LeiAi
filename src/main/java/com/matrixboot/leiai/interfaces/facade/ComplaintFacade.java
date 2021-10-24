package com.matrixboot.leiai.interfaces.facade;

import com.matrixboot.leiai.application.ComplaintCommand;
import com.matrixboot.leiai.application.ComplaintQuery;
import com.matrixboot.leiai.application.service.ComplaintService;
import com.matrixboot.leiai.domain.entity.BlockEntity;
import com.matrixboot.leiai.infrastructure.common.ErrorCodeEnum;
import com.matrixboot.leiai.infrastructure.common.ResultVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 举报模块接口
 * <p>
 * create in 2021/10/23 2:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@AllArgsConstructor
@RestController
@RequestMapping("/complaint")
public class ComplaintFacade {

    private final ComplaintService complaintService;

    @GetMapping("/entity")
    public ResultVO<BlockEntity> lookupSuspicious(ComplaintQuery query) {
        return ResultVO.success(complaintService.lookupSuspicious(query));
    }

    @PostMapping("/new")
    public ResultVO<String> complaint(@RequestBody ComplaintCommand command) {
        complaintService.complaint(command);
        return ResultVO.success("创建成功");
    }

    @PutMapping("/agreement/{id}")
    public ResultVO<String> agreement(@PathVariable long id) {
        return complaintService.agreement(id) ? ResultVO.success(ErrorCodeEnum.ALL_OK) : ResultVO.failure(ErrorCodeEnum.INVALID_INPUT);
    }

}
