import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

import org.junit.Test;

import java.util.Map;
import java.util.HashMap;
import play.test.Helpers;
import play.mvc.Result;
import play.mvc.Http;
import play.mvc.Http.RequestBuilder;
import play.Application;
import play.twirl.api.Content;

import tables.SearchTable;


public class ApplicationTest {
    play.Application fakeApp = fakeApplication();

  @Test
  public void testIndex() {
    RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/");
    Result result = route(fakeApp,request);
    assertEquals(OK, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("渡辺 曜"));
  }

  @Test
  public void testSearch(){
    Map<String, String> formData = new HashMap<>();
    formData.put("searchWord", "渡辺 曜");
    RequestBuilder request = Helpers.fakeRequest().method(POST).uri("/").bodyForm(formData);
    Result result = route(fakeApp, request);
    assertEquals(OK, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("渡辺 曜"));
    assertFalse(contentAsString(result).contains("小原 鞠莉"));

  }

}