import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import play.test.Helpers;
import play.mvc.Result;
import play.twirl.api.Content;
import play.mvc.Http;
import play.mvc.Http.RequestBuilder;
import play.Application;
import io.ebean.Finder;

import tables.T_User;



public class UserControllerTest {
    play.Application fakeApp = fakeApplication();

    @Test
    public void testInit() {
        RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/user");
        Result result = route(fakeApp,request);
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
    }

    @Test
    public void testCreate() {
        Map<String, String> formData = new HashMap<>();
        formData.put("name", "テスト 太郎");
        RequestBuilder request = Helpers.fakeRequest().method(POST).uri("/user").bodyForm(formData);
        Result result = route(fakeApp, request);
        Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
        List<T_User> people = finder.all();
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
        assertEquals("テスト 太郎", people.get(9).getName());
    }
    
    @Test
    public void testEdit() {
        RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/user/1");
        Result result = route(fakeApp,request);
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
        assertTrue(contentAsString(result).contains("高海 千歌"));
    }

    @Test
    public void testUpdate() {
        Map<String, String> formData = new HashMap<>();
        formData.put("name", "テスト 次郎");
        RequestBuilder request = Helpers.fakeRequest().method(POST).uri("/user/2").bodyForm(formData);
        Result result = route(fakeApp, request);
        Finder<Long, T_User> finder = new Finder<Long, T_User>(T_User.class);
        List<T_User> people = finder.all();
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
        assertEquals("テスト 次郎", people.get(0).getName());
    }

    @Test
    public void testDelete() {
        RequestBuilder request = Helpers.fakeRequest().method(POST).uri("/user/delete/1");
        Result result = route(fakeApp,request);
        assertEquals(303, result.status());
    }






}
