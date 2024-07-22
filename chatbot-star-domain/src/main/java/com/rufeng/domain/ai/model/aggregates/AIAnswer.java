package com.rufeng.domain.ai.model.aggregates;

import com.rufeng.domain.ai.model.vo.Choices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: AIAnswer
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 17:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AIAnswer {

    private String id;

    private String object;

    private String created;

    private String model;

    private List<Choices> choices;

}
