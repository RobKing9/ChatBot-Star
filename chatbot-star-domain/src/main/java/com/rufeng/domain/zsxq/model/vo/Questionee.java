package com.rufeng.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Questionee
 * @Description: '
 * @Author: Rufeng
 * @Date: 2024-07-22 15:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionee {

    private String userId;

    private String name;

    private String avatarUrl;

    private String description;

    private String location;

}
