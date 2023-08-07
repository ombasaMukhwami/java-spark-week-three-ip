package com.kabrasoft.utils;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

public final class Helper {
    private Helper() {

    }

    public static String render(Map<Integer, Object> model, String templateName) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templateName));
    }
}
