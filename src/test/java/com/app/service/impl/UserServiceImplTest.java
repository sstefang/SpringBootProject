package com.app.service.impl;

import com.app.exceptions.UsernameAlreadyExistingException;
import com.app.model.Role;
import com.app.model.User;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserServiceImpl userServiceImplUnderTest;

    @Before
    public void setUp() {
        userServiceImplUnderTest = new UserServiceImpl(mockUserRepository, mockRoleRepository, mockBCryptPasswordEncoder);
    }

    @Test
    public void testFindByEmail() {

        final User user = new User();
        user.setUsername("username23");
        user.setPassword("password");
        user.setPasswordConfirm("password");
        final Role role = new Role();
        role.setName("user");
        role.setUsers(new HashSet<>(Arrays.asList(new User())));
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        user.setAge(20);
        user.setEmail("email");
        when(mockUserRepository.findByEmail("email")).thenReturn(user);

        final User result = userServiceImplUnderTest.findByEmail("email");

    }

    @Test
    public void testSave() throws Exception {


        final User user = new User();
        user.setUsername("user0");
        user.setPassword("password");
        user.setPasswordConfirm("password");
        final Role role = new Role();
        role.setName("user");
        role.setUsers(new HashSet<>(Arrays.asList(new User())));
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        user.setAge(0);
        user.setEmail("email");

        final User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword("password");
        user1.setPasswordConfirm("password");
        final Role role1 = new Role();
        role1.setName("user");
        role1.setUsers(new HashSet<>(Arrays.asList(new User())));
        user1.setRoles(new HashSet<>(Arrays.asList(role1)));
        user1.setAge(19);
        user1.setEmail("email");
        when(mockUserRepository.findByUsername("username")).thenReturn(user1);


        final Role role2 = new Role();;
        role2.setName("user");
        final User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("password");
        user2.setPasswordConfirm("passwordConfirm");
        user2.setRoles(new HashSet<>(Arrays.asList(new Role())));
        user2.setAge(18);
        user2.setEmail("email");
        role2.setUsers(new HashSet<>(Arrays.asList(user2)));
        when(mockRoleRepository.findByName("user")).thenReturn(role2);

        final User user3 = new User();
        user3.setUsername("user3");
        user3.setPassword("password");
        user3.setPasswordConfirm("password");
        final Role role3 = new Role();
        role3.setName("user");
        role3.setUsers(new HashSet<>(Arrays.asList(new User())));
        user3.setRoles(new HashSet<>(Arrays.asList(role3)));
        user3.setAge(20);
        user3.setEmail("email");
        when(mockUserRepository.save(any(User.class))).thenReturn(user3);
        userServiceImplUnderTest.save(user);
    }

    @Test(expected = UsernameAlreadyExistingException.class)
    public void testSave_ThrowsUsernameAlreadyExistingException() throws Exception {

        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setPasswordConfirm("password");
        final Role role = new Role();
        role.setName("name");
        role.setUsers(new HashSet<>(Arrays.asList(new User())));
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        user.setEmail("email");

        final User user1 = new User();
        user1.setUsername("username");
        user1.setPassword("password1");
        user1.setPasswordConfirm("password1");
        final Role role1 = new Role();
        role1.setId(0L);
        role1.setName("name");
        role1.setUsers(new HashSet<>(Arrays.asList(new User())));
        user1.setRoles(new HashSet<>(Arrays.asList(role1)));
        user1.setAge(20);
        user1.setEmail("email");
        when(mockUserRepository.findByUsername("username")).thenReturn(user1);
        userServiceImplUnderTest.save(user);
    }

    @Test
    public void testFindByUsername() {
        final User user = new User();
        user.setUsername("user9");
        user.setPassword("password");
        user.setPasswordConfirm("password");
        final Role role = new Role();
        role.setName("user");
        role.setUsers(new HashSet<>(Arrays.asList(new User())));
        user.setRoles(new HashSet<>(Arrays.asList(role)));
        user.setAge(25);
        user.setEmail("email");
        when(mockUserRepository.findByUsername("username")).thenReturn(user);

        final User result = userServiceImplUnderTest.findByUsername("username");
    }
}
