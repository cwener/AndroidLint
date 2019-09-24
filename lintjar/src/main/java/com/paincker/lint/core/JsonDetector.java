package com.paincker.lint.core;

import com.android.tools.lint.checks.StringFormatDetector;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMethodCallExpression;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.List;

import utils.JsonUtils;
import utils.JsonUtils2;

/**
 * Created by chengwen on 2019-09-23
 */
public class JsonDetector extends StringFormatDetector implements Detector.JavaPsiScanner {
    private static final String ISSUE_ID = "JsonSplicingError";
    private static final String ISSUE_BRIEF_DESC = "json拼接可能存在错误";
    private static final String ISSUE_EXPLANNATION = "该字符串可能是一个json，且拼接可能存在错误。如果不是json，忽略此条建议";
    public static final Issue ISSUE = Issue.create(
            ISSUE_ID,
            ISSUE_BRIEF_DESC,
            ISSUE_EXPLANNATION,
            Category.SECURITY, 5, Severity.ERROR,
            new Implementation(JsonDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public void visitMethod(JavaContext context, JavaElementVisitor visitor, PsiMethodCallExpression call, PsiMethod method) {
        super.visitMethod(context, visitor, call, method);
        if ("format".equals(method.getName())) {
            String json = call.getArgumentList().getExpressions()[0].getText();
            //字符串里包含{}可能是一个json，检查一下
            if (json.contains("{") && json.contains("}")) {
                // 实际中发现这时候取出来的时候json前后都多加了一个引号
                json = json.substring(1, json.length() - 1);
                if (!JsonUtils2.isJson(json)) {
                    context.report(ISSUE, call, context.getLocation(call.getMethodExpression()), ISSUE_BRIEF_DESC);
                }
            }
        }


    }
}
