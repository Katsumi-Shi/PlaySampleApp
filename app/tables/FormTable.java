package tables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class FormTable extends BaseTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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