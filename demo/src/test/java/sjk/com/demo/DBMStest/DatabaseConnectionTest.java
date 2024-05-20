package sjk.com.demo.DBMStest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = sjk.com.demo.DemoApplication.class)
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        // 尝试执行简单的查询
        int result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);

        // 如果查询成功，结果应该为1
        assertTrue(result == 1);
    }
}
