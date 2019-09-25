package registry;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.paincker.lint.core.ConstantEqualsDetector;
import com.paincker.lint.core.JsonDetector;
import com.paincker.lint.core.LogDetector;
import com.paincker.lint.core.NewThreadDetector;
import com.paincker.lint.core.rules.detectors.binaryResource.ImageFileSizeDetector;
import com.paincker.lint.core.rules.detectors.java.ActivityFragmentLayoutNameDetector;
import com.paincker.lint.core.rules.detectors.java.ChineseStringDetector;
import com.paincker.lint.core.rules.detectors.java.CloseDetector;
import com.paincker.lint.core.rules.detectors.java.CustomLogDetector;
import com.paincker.lint.core.rules.detectors.java.CustomToastDetector;
import com.paincker.lint.core.rules.detectors.java.EnumDetector;
import com.paincker.lint.core.rules.detectors.java.HardcodedValuesDetector;
import com.paincker.lint.core.rules.detectors.java.HashMapForJDK7Detector;
import com.paincker.lint.core.rules.detectors.java.MessageObtainDetector;
import com.paincker.lint.core.rules.detectors.java.ViewHolderItemNameDetector;
import com.paincker.lint.core.rules.detectors.xml.ViewIdNameDetector;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jzj on 2017/7/4.
 */
public class MyIssueRegistry extends IssueRegistry {

    @Override
    public synchronized List<Issue> getIssues() {
        System.out.println("==== my lint start ====");
        return Arrays.asList(LogDetector.ISSUE, NewThreadDetector.ISSUE, JsonDetector.ISSUE, ChineseStringDetector.ISSUE,
                ActivityFragmentLayoutNameDetector.ACTIVITY_LAYOUT_NAME_ISSUE,
                ActivityFragmentLayoutNameDetector.FRAGMENT_LAYOUT_NAME_ISSUE,
                MessageObtainDetector.ISSUE,
                CustomToastDetector.ISSUE,
                CustomLogDetector.ISSUE,
                ViewIdNameDetector.ISSUE,
                ViewHolderItemNameDetector.ISSUE,
                CloseDetector.ISSUE,
                ImageFileSizeDetector.ISSUE,
                HashMapForJDK7Detector.ISSUE,
                HardcodedValuesDetector.ISSUE,
                EnumDetector.ISSUE,
                ConstantEqualsDetector.ISSUE);
    }
}
