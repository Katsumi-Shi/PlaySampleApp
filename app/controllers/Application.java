package controllers;
import tables.T_User;
import java.util.List;
import java.util.stream.Collectors;

import play.data.Form;
import play.data.FormFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import play.mvc.Controller;
import play.mvc.Result;
import io.ebean.*;

@Singleton
public class Application extends Controller {
	   private Form<FormTable> nameform;
	   private FormFactory formFactory;
	public String searchWord;
	
	 @Inject
	   public Application(FormFactory formFactory) {
	       this.nameform = formFactory.form(FormTable.class);
	   }

    public Result index() {
    	  Finder<Long, T_User> finder = new Finder<Long, T_User>(
                  T_User.class);
    		  List<T_User> people = finder.all();
      return ok(views.html.index.render(people));
     }
    
    public Result search(Http.Request rq) {
    	Form<FormTable> userForm = nameform.bindFromRequest(rq);
        FormTable user = userForm.get();
        searchWord = user.name;
        Query<T_User> query = finder.where("name=searchWord");
        List<T_User> people = query.findUnique();
        return ok(views.html.index.render(people));
    }
}