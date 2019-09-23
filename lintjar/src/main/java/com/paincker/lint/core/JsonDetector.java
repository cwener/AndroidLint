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
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMethodCallExpression;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.List;

import utils.JsonUtils;

/**
 * Created by chengwen on 2019-09-23
 */
public class JsonDetector extends StringFormatDetector implements Detector.JavaPsiScanner {
    public static final Issue ISSUE = Issue.create(
            "JsonSplicingError",
            "json拼接可能存在错误",
            "json拼接可能存在错误，请仔细检查",
            Category.SECURITY, 5, Severity.ERROR,
            new Implementation(JsonDetector.class, Scope.JAVA_FILE_SCOPE));

    @Override
    public void visitMethod(JavaContext context, JavaElementVisitor visitor, PsiMethodCallExpression call, PsiMethod method) {
        super.visitMethod(context, visitor, call, method);
//        String json = call.getArgumentList().getExpressions()[0].getText();
//        if (!new JsonUtils().validate(json)) {
//            context.report(ISSUE, call, context.getLocation(call.getMethodExpression()), "json拼接可能存在错误");
//        }
    }
}
