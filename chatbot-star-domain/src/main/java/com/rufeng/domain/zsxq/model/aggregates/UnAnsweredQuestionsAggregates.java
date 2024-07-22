package com.rufeng.domain.zsxq.model.aggregates;

import com.rufeng.domain.zsxq.model.res.RespData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: UnAnsweredQuestionsAggredates
 * @Description: 未回答问题的聚合信息
 * @Author: Rufeng
 * @Date: 2024-07-22 15:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnAnsweredQuestionsAggregates {

    private boolean isSucceeded;

    private RespData respData;


}
