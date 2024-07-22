package com.rufeng.domain.ai.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Choices
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 17:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choices {

    private String text;

    private int index;

    private String logprobs;

    private String finishReason;

}
