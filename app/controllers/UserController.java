package controllers;

import java.util.List;
import play.mvc.*;
import javax.inject.Singleton;
import com.google.inject.Inject;
import play.data.Form;
import play.data.FormFactory;
import tables.T_User;
import tables.FormTable;
import io.ebean.*;
import play.db.ebean.*;


@Singleton
public class UserController extends Controller{
   private Form<T_User> form;
   private Form<FormTable> form2;
   private FormFactory formFactory;
   T_User tuser = new T_User();

   @Inject
   public UserController(FormFactory formFactory) {
       this.form = formFactory.form(T_User.class);
       this.form2 = formFactory.form(FormTable.class);
   }
   public Result init() {
       return ok(views.html.user.render(tuser, false));
   }
   
   @Transactional
   public Result create(Http.Request rq) {
       Form<FormTable> userForm = form2.bindFromRequest(rq);
       FormTable user = userForm.get();
       T_User user2 = new T_User();
       user2.name = user.name;
       user2.schoolYear = user.schoolYear;
       user2.birthDay = user.birthDay;
       user2.height = user.height;
       user2.food = user.food;
        user2.save();
       return ok(views.html.user.render(tuser, false));
   }
   
   @Transactional
   public Result edit(Long id) {
	   Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
       T_User newuser = finder.byId(id);
       return ok(views.html.user.render(newuser, true));
   }
   
   @Transactional
   public Result update(Http.Request rq, Long id) {
	   Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
       T_User user2 = finder.byId(id);
       T_User newuser = new T_User();
	   Form<FormTable> userForm = form2.bindFromRequest(rq);
       FormTable user = userForm.get();
       user2.delete();
       newuser.id = id;
       newuser.name = user.name;
       newuser.schoolYear = user.schoolYear;
       newuser.birthDay = user.birthDay;
       newuser.height = user.height;
       newuser.food = user.food;
       newuser.save();
       return ok(views.html.user.render(newuser, false));
   }
   
   @Transactional
   public Result delete(Long id) {
	   Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
       T_User user = finder.byId(id);
       user.delete();
       return redirect(routes.Application.index());
   }

}

