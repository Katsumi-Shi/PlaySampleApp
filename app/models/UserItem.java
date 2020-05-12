package models;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tables.T_User;
import javax.persistence.Entity;
@Getter
@NoArgsConstructor
@Entity
public class UserItem {

    public Long id;

    public String name;

    public String schoolYear;

    public String height;

    public String food;
    
    public UserItem(T_User user) {
        this.id = user.id;
        this.name = user.name;
        this.schoolYear = user.schoolYear + "年生";
        this.height = user.height + "cm";
        this.food = user.food;
    }
    
}