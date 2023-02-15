import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.javalin.Javalin;
import io.javalin.core.util.FileUtil;
import io.javalin.http.staticfiles.Location;
import java.util.HashMap;
import java.util.Map;

public class Main {


    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = gsonBuilder.create();
    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public", Location.CLASSPATH);
        }).start(7070);

        app.post("/handleDate", ctx -> {
            DateWrapper dw = gson.fromJson(new String(ctx.body().getBytes()),DateWrapper.class);
            ctx.result(dw.asDate().toString());
        });



    }

}


