package com.matrixboot.leiai.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * create in 2021/9/28 12:23 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    T data;

    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>builder()
                .data(data)
                .build();
    }

    public static <T> ResultVO<T> success() {
        return ResultVO.<T>builder().build();
    }

}
