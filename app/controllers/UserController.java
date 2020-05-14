package controllers;

import java.util.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.ebean.*;
import play.mvc.*;
import play.api.data.Form;
import tables.T_User;

public class UserController extends Controller{
		public Result init() {
	        return ok(views.html.user.render());
	    }
}