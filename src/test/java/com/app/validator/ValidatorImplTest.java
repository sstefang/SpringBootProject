package com.app.validator;

import com.app.model.Role;
import com.app.model.User;
import com.app.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.Errors;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorImplTest {

    @Mock
    private UserService mockUserService;

    private ValidatorImpl validatorImplUnderTest;

    @Before
    public void setUp() {
        validatorImplUnderTest = new ValidatorImpl(mockUserService);
    }

    @Test
    public void testSupports() {

        final boolean result = validatorImplUnderTest.supports(Object.class);

        assertTrue(result);
    }

    @Test
    public void testValidate() {
        final Errors errors = null;

        final User user = new User();
        user.setId(0L);
        user.setUsername("username");
        user.setPassword("password");
        user.setPasswordConfirm("passwordConfirm");
        final Role role = new Role();
        role.setId(0L);
        role.setName("name");
        role.setUsers(new HashSet<>(Arrays.asList(new User())));
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        user.setAge(0);
        user.setEmail("email");
        when(mockUserService.findByUsername("username")).thenReturn(user);

        validatorImplUnderTest.validate("o", errors);
    }
}
