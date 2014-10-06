package controllers;

import com.newrelic.api.agent.NewRelic;
import controllers.routes;
import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.file;
import views.html.index;

import java.io.InputStream;

public class Application extends Controller {

    public static final String DISPOSITION_VALUE = "attachment;filename=\"%s\"";

    public static Result index() {
        return ok(file.render(controllers.routes.Application.file()));
    }

    public static Result file() {
        InputStream inputStream = Play.application().resourceAsStream("PMS475.pdf");
        response().setHeader("Content-Disposition", String.format(DISPOSITION_VALUE, "sample-file.pdf"));
        return ok(inputStream);
    }

    public static Result ping() {
        NewRelic.ignoreTransaction();
        return ok("echo");
    }
}
