package com.rufeng.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: UserSpecific
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 15:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSpecific {

    private boolean isLiked;

    private boolean isSubscribed;

}
