package test;

import java.util.Set;

import tables.FormTable;
import tables.T_User;

public interface T_UserRepository {
    public Set<FormTable> findT_UserForm(T_User t_user);
}
