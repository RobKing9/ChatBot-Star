package com.rufeng.domain.zsxq.model.res;

import com.rufeng.domain.zsxq.model.vo.Topics;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: RespData
 * @Description: 结果数据
 * @Author: Rufeng
 * @Date: 2024-07-22 15:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespData {

    private List<Topics> topics;

}
