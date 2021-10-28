package com.matrixboot.leiai.application;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.matrixboot.leiai.domain.BlockTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @JsonDeserialize(using = BlockTypeJsonDeserialize.class)
    @NotNull(message = "举报的类型不能为空")
    private BlockTypeEnum type;

    @NotBlank(message = "举报的对象不能为空")
    private String value;

    static class BlockTypeJsonDeserialize extends JsonDeserializer<BlockTypeEnum> {

        private static final Map<String, BlockTypeEnum> MAP = new HashMap<>();

        {
            MAP.put("QQ", BlockTypeEnum.QQ);
            MAP.put("微信", BlockTypeEnum.WECHAT);
            MAP.put("邮箱", BlockTypeEnum.EMAIL);
            MAP.put("电话", BlockTypeEnum.PHONE);
        }

        @Override
        public BlockTypeEnum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return MAP.getOrDefault(p.getValueAsString(), null);
        }

    }

}
