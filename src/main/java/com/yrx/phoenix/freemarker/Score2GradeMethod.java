package com.yrx.phoenix.freemarker;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * Created by r.x on 2019/4/13.
 */
public class Score2GradeMethod implements TemplateMethodModelEx {
    public static final String METHOD_NAME = "score2Grade";

    @Override
    public Object exec(List arguments) throws TemplateModelException {
        if (arguments.get(0) instanceof SimpleNumber) {
            SimpleNumber number = (SimpleNumber) arguments.get(0);
            if (number.getAsNumber().doubleValue() > 80) {
                return "优秀";
            } else {
                return "还行";
            }
        }
        return null;
    }
}
