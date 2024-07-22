import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @ClassName: ApiTest
 * @Description: test
 * @Author: Rufeng
 * @Date: 2024-07-22 11:30
 **/
public class ApiTest {

    String cookie = "zsxq_access_token=CE0E4B15-A0B5-2BE0-76AB-FB340B49A762_2B126A59EA20E2B2; zsxqsessionid=28a9a0c6c5acf914838e267eb45a8a9f; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22190c49b2089f11-0717cf1e214a608-19525637-1484784-190c49b208a26c3%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkwYzQ5YjIwODlmMTEtMDcxN2NmMWUyMTRhNjA4LTE5NTI1NjM3LTE0ODQ3ODQtMTkwYzQ5YjIwOGEyNmMzIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%22190c49b2089f11-0717cf1e214a608-19525637-1484784-190c49b208a26c3%22%7D; abtest_env=beta";

    @Test
    public void QueryUnAnswerQuestion() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/topics/1522184885142512/comments?sort=asc&count=30&with_sticky=true");
        
        httpGet.addHeader("cookie", cookie);
        httpGet.addHeader("Content-Type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("");
        httpPost.addHeader("cookie", cookie);
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");

        String paramJson = "";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testChatGPT() throws IOException{

        String openAiKey = "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";

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + openAiKey);

        String paramJson = "{\n" +
                "     \"model\": \"gpt-4o-mini\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"写一个冒泡排序\"}],\n" +
                "     \"temperature\": 0.7\n" +
                "   }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
