package sjk.com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void createHotelTable() {
//        String sql = "CREATE TABLE hotel (" +
//            "id INT AUTO_INCREMENT, " +
//            "name VARCHAR(255), " +
//            "address VARCHAR(255), " +
//            "rating DECIMAL(3,2), " +
//            "PRIMARY KEY (id)" +
//            ");";
//        jdbcTemplate.execute(sql);
//    }
}