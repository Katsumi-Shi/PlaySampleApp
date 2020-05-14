package controllers;
import tables.T_User;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;
import play.mvc.Controller;
import play.mvc.Result;
import io.ebean.Finder;

@Singleton
public class Application extends Controller {

    public Result index() {
    	  Finder<Long, T_User> finder = new Finder<Long, T_User>(
                  T_User.class);
          List<T_User> people = finder.all();
      return ok(views.html.index.render(people));
     }
}