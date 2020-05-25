package test;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import test.T_UserRepository;
import tables.FormTable;
import tables.T_User;

public class testModel {

    @Test
    public void testIsAdmin() {

    // Create and train mock repository
    T_UserRepository repositoryMock = mock(T_UserRepository.class);
    Set<FormTable> forms = new HashSet<FormTable>();
    FormTable item = new FormTable();
    item.name = "ADMIN";
    forms.add(new FormTable());
    when(repositoryMock.findT_UserForm(any(T_User.class))).thenReturn(forms);

    // Test Service
    T_UserService t_userService = new T_UserService(repositoryMock);
    T_User t_user = new T_User();
    t_user.name = "Sample1";
    assertTrue(t_userService.isAdmin(t_user));
    verify(repositoryMock).findT_UserForm(t_user);
}
    
}