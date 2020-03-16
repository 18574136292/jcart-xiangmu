package io.itcast.cfc.dao;

import io.itcast.cfc.model.Administrator;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

//@SpringBootTest
public class AdministratorMapperTest {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Test
    public void selectByUsername(){
        String username = "zhangsan";
        Administrator administrator = administratorMapper.selectByUsername(username);
        assertNotNull(administrator);
        username = "zhangsan111";
        administrator = administratorMapper.selectByUsername(username);
        assertNull(administrator);
    }

    @Test
    public void testOne(){
        Administrator administrator = administratorMapper.selectByUsername("zhangsan");
        System.out.println(administrator);
    }
}
