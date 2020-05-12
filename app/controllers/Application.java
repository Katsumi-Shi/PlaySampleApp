package controllers;

import java.util.*;
import java.util.stream.Collectors;

import javax.inject.*;
import javax.inject.Inject;
import javax.inject.Singleton;

import models.UserItem;
import play.mvc.*;
import play.mvc.Controller;
import play.mvc.Result;
import tables.T_User;
import io.ebean.*;
import play.db.*;


@Singleton
public class Application extends Controller {

    Long id;

    String name;

    String schoolYear;
    
    String height;

    String food;
    
    @Inject
    public Application(UserItem user) {
        this.id = user.id;
        this.name = user.name;
        this.schoolYear = user.schoolYear + "年生";
        this.height = user.height + "cm";
        this.food = user.food;
    }

    public Result index() {
        return ok(views.html.index.render(id,name,schoolYear,height,food));
    }
}