import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

import static play.test.Helpers.*;
import play.test.Helpers;
import org.junit.Test;

import play.mvc.Result;
import play.twirl.api.Content;
import play.mvc.Http.RequestBuilder;
import play.data.Form;
import play.data.FormFactory;
import tables.SearchTable;
import play.Application;



public class ApplicationTest {
    Application fakeApp = fakeApplication();

  @Test
  public void testIndex() {
    RequestBuilder request = Helpers.fakeRequest().method(GET).uri("/");
    Result result = route(fakeApp,request);
    assertEquals(OK, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("高海 千歌"));
  }

}