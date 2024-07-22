package com.rufeng.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: Owner
* @Description: 知识星球创建人
* @Author: Rufeng
* @Date: 2024-07-22 15:21
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    private String userId;

    private String name;

    private String avatarUrl;

    private String location;

}
