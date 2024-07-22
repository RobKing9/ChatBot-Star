import com.alibaba.fastjson.JSON;
import com.rufeng.domain.ai.IOpenAI;
import com.rufeng.domain.zsxq.IZsxqApi;
import com.rufeng.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import com.rufeng.domain.zsxq.model.vo.Topics;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: SpringBootRunTest
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 16:14
 **/
@Slf4j
public class SpringBootRunTest {

    @Value("${chatbot-api.groupId}")
    private String groupId;

    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    private IZsxqApi zsxqApi;

    @Test
    public void testZsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates  unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        log.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getRespData().getTopics();
        log.info("topics：{}", topics.size());
//        for (Topics topic : topics) {
//            String topicId = topic.getTopicId();
//            String text = topic.getQuestion().getText();
//            log.info("topicId：{} text：{}", topicId, text);
//
//            // 回答问题
////            zsxqApi.answer(groupId, cookie, topicId, openAI.doChatGPT(openAiKey, text), false);
//        }
    }

    @Resource
    private IOpenAI  openAI;

    @Test
    public void testChatGPT() throws IOException {

        String response = openAI.doChatGPT("写一个冒泡排序");
        log.info("测试结果：{}", response);
    }
}
