package controllers;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.file;
import views.html.index;

import java.io.InputStream;

public class Application extends Controller {

    public static final String DISPOSITION_VALUE = "attachment;filename=\"%s\"";

    public static Result index() {
        return ok(file.render(routes.Application.file()));
    }

    public static Result file() {
        InputStream inputStream = Play.application().resourceAsStream("PMS475.pdf");
        response().setHeader("Content-Disposition", String.format(DISPOSITION_VALUE, "sample-file.pdf"));
        return ok(inputStream);
    }

}
