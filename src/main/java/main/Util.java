package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;

public class Util {
    public static void logEnvironment(Object event, Context context, Gson gson) {
        LambdaLogger logger = context.getLogger();
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // log event details
        logger.log("EVENT: " + gson.toJson(event));
        logger.log("EVENT TYPE: " + event.getClass().toString());
    }

    public static String getRequestBody(String color){
        StringBuilder page = new StringBuilder("<!DOCTYPE html>");
        page.append("<html>");
        page.append("<head>");
        page.append("<title>AWS Lambda bluegreen</title>");
        page.append("</head>");
        page.append(String.format("<body bgcolor=\"%s\">", color));
        page.append(String.format("<p style=\"color:white;\">Hello %s!</p>", color));
        page.append("</body>");
        page.append("</html>");
        return page.toString();
    }
}
