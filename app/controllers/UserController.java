package controllers;

import java.util.List;
import play.mvc.*;
import javax.inject.Singleton;
import com.google.inject.Inject;
import play.data.Form;
import play.data.FormFactory;
import tables.T_User;
import tables.FormTable;
import io.ebean.Finder;
import play.db.ebean.Transactional;

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
       T_User user = finder.byId(id);
       System.out.println(user);
       return ok(views.html.user.render(tuser, true));
   }
   
   @Transactional
   public Result update(Http.Request rq, Long id) {
	   Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
       T_User iduser = finder.byId(id);
	   Form<FormTable> userForm = form2.bindFromRequest(rq);
       FormTable user = userForm.get();
       T_User user2 = new T_User();
       System.out.println(user2);
       //user2.id = iduser.id;
       user2.name = user.name;
       System.out.println(user2.name);
       System.out.println(iduser.id);
       user2.schoolYear = user.schoolYear;
       user2.birthDay = user.birthDay;
       user2.height = user.height;
       user2.food = user.food;
	   user2.update();
       return ok(views.html.user.render(tuser, true));
   }
   
   @Transactional
   public Result delete(Long id) {
	   Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
       T_User user = finder.byId(id);
       user.delete();
       return redirect(routes.Application.index());
   }

}

