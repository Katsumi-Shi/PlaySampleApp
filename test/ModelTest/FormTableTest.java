import static org.junit.Assert.*;
import org.junit.Test;
import tables.FormTable;

public class FormTableTest {

    @Test
    public void formtableTest() {
    FormTable user = new FormTable();
    user.name = "Sample1";
    assertEquals("Sample1", user.name);
}
    
}