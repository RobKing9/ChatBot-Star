package com.rufeng.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Topic
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 15:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topics {

    private String topicId;

    private Group  group;

    private Question question;

    private Questionee questionee;

    private boolean isAnswered;

    private int likesCount;

    private int rewardsCount;

    private int commentsCount;

    private int readingCount;

    private int readersCount;

    private boolean digested;

    private boolean sticky;

    private String creatTime;

    private UserSpecific  userSpecific;

}
