package com.example.gaokao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class GaoKaoApplicationTests {
   @Autowired
   private DataSource dataSource;
   @Autowired

   /*
   测试连接池
   * */
    @Test
    void contextLoads() {
        System.out.printf("dataSource: %s", dataSource.getClass());
    }

}
