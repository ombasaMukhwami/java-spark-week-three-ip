package com.kabrasoft.utils;

import com.kabrasoft.constants.Species;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

public final class Helper {
    private Helper() {

    }

    public static String render(Map<Integer, Object> model, String templateName) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templateName));
    }

    public static Species getSpecies(String species) {
        return switch (species) {
            case "EndangeredAnimal" -> Species.ENDANGERED_ANIMAL;
            default -> Species.ANIMAL;
        };
    }
}
