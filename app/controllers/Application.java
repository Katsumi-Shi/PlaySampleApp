package controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import io.ebean.*;

import tables.FormTable;
import play.db.ebean.*;

import tables.T_User;
import tables.SearchTable;

@Singleton
public class Application extends Controller {
	private Form<SearchTable> nameform;
	private Query<T_User> query;
	public String searchWord;
	
	 @Inject
	 FormFactory formFactory;

    public Result index() {
    	Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
    	List<T_User> people = finder.all();
    	return ok(views.html.index.render(people));
     }
    
    public Result search(Http.Request rq) {
		System.out.println(rq);
		nameform = formFactory.form(SearchTable.class);
		Form<SearchTable> userForm = nameform.bindFromRequest(rq);
		System.out.println(userForm);
		SearchTable user = userForm.get();
		System.out.println(user);
        searchWord = user.searchWord;
        System.out.println(searchWord);
        Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
        if (searchWord.length() == 0) {  
    	List<T_User> people = finder.all();
    		return ok(views.html.index.render(people));
    	}else {
        	List<T_User> people = finder.query().where().eq("name", searchWord).findList();
        	return ok(views.html.index.render(people));
    	}
    }
}