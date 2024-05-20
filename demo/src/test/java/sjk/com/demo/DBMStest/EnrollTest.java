package sjk.com.demo.DBMStest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sjk.com.demo.entity.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import sjk.com.demo.service.Enrollmentusers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class EnrollTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterUser() throws Exception {
        // 创建一个用户对象
        Users user = new Users();
        user.setUsername("testuser1");
        user.setPassword("password");
        user.setNumber("1234567890");
        user.setDate("2024-05-20");
        user.setType(1);

        // 将用户对象转换为JSON
        String userJson = objectMapper.writeValueAsString(user);

        // 发送POST请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk())
                .andReturn();

        // 获取响应内容
        String responseJson = result.getResponse().getContentAsString();

        // 将响应内容转换为 RegistrationResponse 对象
        Enrollmentusers.RegistrationResponse response = objectMapper.readValue(responseJson, Enrollmentusers.RegistrationResponse.class);

        // 输出响应信息
        System.out.println("Response isOK: " + response.isOK());
        System.out.println("Response Code: " + response.getCode());
        System.out.println("Response Message: " + response.getMessage());

        // 断言检查
        assertThat(response.isOK()).isTrue();
        assertThat(response.getCode()).isEqualTo("200");
        assertThat(response.getMessage()).isEqualTo("User registered successfully");
    }
}
