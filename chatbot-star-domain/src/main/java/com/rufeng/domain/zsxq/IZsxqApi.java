package com.rufeng.domain.zsxq;


import com.rufeng.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

public interface IZsxqApi {

    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean isSilenced) throws IOException;

}
