package org.shigm.consumer;

import org.shigm.commons.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author shigm
 * @date 2020/3/25 21:32
 */
@RestController
public class UseController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    @Qualifier(value = "restTemplateOne")
    RestTemplate restTemplateOne;
    @Autowired
    @Qualifier(value = "restTemplateTwo")
    RestTemplate restTemplateTwo;

    @GetMapping("/hello1")
    public String hello1() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL("http://localhost:1113/hello");
            connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String s = reader.readLine();
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "error";
    }

    @GetMapping("/hello2")
    public String hello2() {

        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = list.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        StringBuffer sb = new StringBuffer();
        sb.append("http://").append(host).append(":").append(port).append("/hello");
        HttpURLConnection connection = null;
        String object = restTemplateOne.getForObject(sb.toString(), String.class);

        return object;
    }

    int count = 0;

    @GetMapping("/hello3")
    public String hello3() {
        String forObject = restTemplateTwo.getForObject("http://provider/hello", String.class);
        return forObject;
    }

    @GetMapping("/hello4")
    public void hello4() {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("userName", "shigm");
        map.add("password", "123");
        map.add("id", 7);
        User user = restTemplateTwo.postForObject("http://provider/addUser", map, User.class);
        System.out.println(user);
        System.out.println("=========");

        user.setId(8);
        user.setUserName("yangj");

        User user1 = restTemplateTwo.postForObject("http://provider/addUser2", user, User.class);
        System.out.println(user1);
        System.out.println("===========");

    }
}
