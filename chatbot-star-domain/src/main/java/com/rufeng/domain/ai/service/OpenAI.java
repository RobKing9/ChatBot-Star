package com.rufeng.domain.ai.service;

import com.alibaba.fastjson.JSON;
import com.rufeng.domain.ai.IOpenAI;
import com.rufeng.domain.ai.model.aggregates.AIAnswer;
import com.rufeng.domain.ai.model.vo.Choices;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: OpenAI
 * @Description:
 * @Author: Rufeng
 * @Date: 2024-07-22 17:18
 **/
@Slf4j
@Service
public class OpenAI implements IOpenAI
{
    @Value("${openai.key}")
    private String openAiKey;

    @Override
    public String doChatGPT(String question) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + openAiKey);

        String paramJson = "{\n" +
                "     \"model\": \"gpt-4o-mini\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": + \"" + question + "\"}],\n" +
                "     \"temperature\": 0.7\n" +
                "   }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for (Choices choice : choices) {
                answers.append(choice.getText());
            }
            return answers.toString();
        } else {
            throw new RuntimeException("请求失败: " + response.getStatusLine().getStatusCode());
        }
    }
}
