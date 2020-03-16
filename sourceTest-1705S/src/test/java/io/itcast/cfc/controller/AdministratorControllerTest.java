package io.itcast.cfc.controller;

import io.itcast.cfc.dto.in.AdministratorLoginInDTO;
import io.itcast.cfc.dto.out.AdministratorLoginOutDTO;
import io.itcast.cfc.exception.ClientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministratorControllerTest {

    @Autowired
    private AdministratorController administratorController;

    @Test
    public void login() throws ClientException {
        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("zhangsan");
        administratorLoginInDTO.setPassword("123456");
        AdministratorLoginOutDTO login = administratorController.login(administratorLoginInDTO);
        assertNotNull(login);
    }
}