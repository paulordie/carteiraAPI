package com.wallet.repository;

import com.wallet.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "email@test.com";

    @Autowired
    UserRepository repository;

    @Before
    public void setUp(){
        User u = new User();
        u.setName("Set up User");;
        u.setPassword("Senha123");
        u.setEmail(EMAIL);

        repository.save(u);
    }

    @After
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    public void testSave(){
        User u = new User();
        u.setName("Teste");
        u.setPassword("123456");
        u.setEmail("paulordie@gmail.com");

        User response = repository.save(u);

        assertNotNull(response);
    }

    public void testFindByEMail(){
        Optional<User> response = repository.fynByEmail(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}
