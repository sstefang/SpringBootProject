package com.app.service.impl;

import com.app.model.Role;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

    @Mock
    private UserRepository mockUserRepository;

    private UserDetailsServiceImpl userDetailsServiceImplUnderTest;

    @Before
    public void setUp() {
        userDetailsServiceImplUnderTest = new UserDetailsServiceImpl(mockUserRepository);
    }

    @Test
    public void testLoadUserByUsername() {

        final User user = new User();
        user.setUsername("user2312");
        user.setPassword("user2312");
        user.setPasswordConfirm("user2312");
        final Role role = new Role();
        role.setName("user");
        role.setUsers(new HashSet<>(Arrays.asList(new User())));
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        user.setAge(0);
        user.setEmail("user2312@email.com");
        when(mockUserRepository.findByUsername("user2312")).thenReturn(user);

        final UserDetails result = userDetailsServiceImplUnderTest.loadUserByUsername("user2312");

    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsername_ThrowsUsernameNotFoundException() {
        userDetailsServiceImplUnderTest.loadUserByUsername("username1");
    }
}
