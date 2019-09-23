package registry;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.paincker.lint.core.LogDetector;
import com.paincker.lint.core.NewThreadDetector;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jzj on 2017/7/4.
 */
public class MyIssueRegistry extends IssueRegistry {

    @Override
    public synchronized List<Issue> getIssues() {
        System.out.println("==== my lint start ====");
        return Arrays.asList(LogDetector.ISSUE, NewThreadDetector.ISSUE);
    }
}
