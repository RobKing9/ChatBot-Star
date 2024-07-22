package com.rufeng.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Group
 * @Description: 知识星球Group
 * @Author: Rufeng
 * @Date: 2024-07-22 15:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    private String groupId;

    private String name;

    private String type;
}
