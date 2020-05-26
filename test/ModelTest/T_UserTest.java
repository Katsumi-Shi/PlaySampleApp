import static org.junit.Assert.*;
import org.junit.Test;
import tables.T_User;

public class T_UserTest {

    @Test
    public void t_userTest() {
    T_User user = new T_User();
    user.name = "Sample1";
    assertEquals("Sample1", user.name);
}
    
}