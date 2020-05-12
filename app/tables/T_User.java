package tables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.api.data.validation.*;
import tables.find.All;
import tables.find.Fuzzy;

@Entity
@Table(name = "t_user")
public class T_User extends BaseTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public Integer schoolYear;

    public Integer height;

    public String food;

    public boolean isEmpty() {
        return id == null;
    }
}