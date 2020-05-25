package test;

import java.util.Set;
import test.T_UserRepository;
import tables.FormTable;
import tables.T_User;

public class T_UserService {
    private final T_UserRepository t_userRepository;


public T_UserService(final T_UserRepository t_userRepository) {
    this.t_userRepository = t_userRepository;
  }

  public boolean isAdmin(final T_User t_user) {
    final Set<FormTable> formTable = t_userRepository.findT_UserForm(t_user);
    for (FormTable form : formTable) {
      if (form.name.equals("ADMIN")) return true;
    }
    return false;
  }
}