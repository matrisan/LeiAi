package com.matrixboot.leiai.application;

import com.matrixboot.leiai.domain.BlockTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 投诉命令
 * <p>
 * create in 2021/10/23 2:39 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class ComplaintCommand {

    @NotNull(message = "举报的类型不能为空")
    private BlockTypeEnum type;

    @NotBlank(message = "举报的对象不能为空")
    private String value;

}
