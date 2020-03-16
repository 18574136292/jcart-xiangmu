package io.itcast.cfc.service.impl;

import io.itcast.cfc.model.Administrator;
import io.itcast.cfc.service.AdministratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AdministratorServiceImplTest {

    @Autowired
    private AdministratorService administratorService;

    @Test
    public void getByUsername() {
        String username = "zhangsan";
        Administrator administrator = administratorService.getByUsername(username);
        assertNotNull(administrator);
        username = "zhangsan111";
        administrator = administratorService.getByUsername(username);
        assertNull(administrator);
    }
}
