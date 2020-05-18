package tables;

import java.util.Date;
import javax.persistence.Id;

public class FormTable extends BaseTable{
	
	    @Id
	    public Long id;

	    public String name;

	    public Integer schoolYear;
	    
	    public Date birthDay;

	    public Integer height;

	    public String food;

	    public boolean isEmpty() {
	        return id == null;
	    }
	}
