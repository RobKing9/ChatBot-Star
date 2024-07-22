package com.rufeng.domain.zsxq.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ReqData
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 15:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqData {

    private String text;

    private String[] imageIds = new String[]{};

    private boolean isSilenced;

    public ReqData(String text, boolean isSilenced) {
        this.text = text;
        this.isSilenced = isSilenced;
    }
}
