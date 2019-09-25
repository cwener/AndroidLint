package com.paincker.lint.core;

import com.android.tools.lint.client.api.JavaParser;
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

import java.util.Collections;
import java.util.List;

import lombok.ast.AstVisitor;
import lombok.ast.MethodInvocation;

/**
 * Created by chengwen on 2019-09-25
 * 常量和变量进行equal比较的时候，应该由常量来调用equals方法
 */
public class ConstantEqualsDetector extends Detector implements Detector.JavaScanner {
    private static final String ISSUE_ID = "ConstantEqualsWarning";
    private static final String ISSUE_BRIEF_DESC = "equals中含有常量的比较";
    private static final String ISSUE_EXPLANNATION = "equals中含有常量和变量时，应该由常量来调用equals方法，避免NPE";
    public static final Issue ISSUE = Issue.create(
            ISSUE_ID,
            ISSUE_BRIEF_DESC,
            ISSUE_EXPLANNATION,
            Category.SECURITY, 5, Severity.ERROR,
            new Implementation(ConstantEqualsDetector.class, Scope.JAVA_FILE_SCOPE));

    private static final String CHECK_CLSS = "java.lang.String";

    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList("equals");
    }

    @Override
    public void visitMethod(JavaContext context, AstVisitor visitor, MethodInvocation node) {
        JavaParser.ResolvedNode resolvedNode = context.resolve(node);
        if (resolvedNode instanceof JavaParser.ResolvedMethod) {
            JavaParser.ResolvedMethod method = (JavaParser.ResolvedMethod) resolvedNode;
            JavaParser.ResolvedClass resolvedClass = method.getContainingClass();
            if (resolvedClass.isSubclassOf(CHECK_CLSS, false)) {
                String nodeStr = node.toString();
                String arg = node.astArguments().first().toString();
                if (!"\"\"".equals(arg)) {

                }
            }
        }
    }

}
