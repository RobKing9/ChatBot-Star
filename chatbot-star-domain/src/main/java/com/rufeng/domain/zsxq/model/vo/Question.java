package com.rufeng.domain.zsxq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Question
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 15:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private Owner owner;

    private Questionee questionee;

    private String text;

    private boolean expired;

    private boolean anonymous;

    private OwnerDetail ownerDetail;

    private String ownerLocation;
}
