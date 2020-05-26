import static org.junit.Assert.*;
import org.junit.Test;
import tables.SearchTable;

public class SearchTableTest {

    @Test
    public void searchtableTest() {
    SearchTable user = new SearchTable();
    user.searchWord = "Sample1";
    assertEquals("Sample1", user.searchWord);
}
    
}