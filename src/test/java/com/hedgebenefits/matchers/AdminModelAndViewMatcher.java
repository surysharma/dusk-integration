package com.hedgebenefits.matchers;

import com.hedgebenefits.domain.Admin;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 30/05/2012
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */
public class AdminModelAndViewMatcher extends TypeSafeMatcher<ModelAndView> {

    @Override
    public void describeTo(Description description) {
        description.appendText("ModelAndView does not match");
    }

    @Override
    public boolean matchesSafely(ModelAndView modelAndView) {
        boolean viewNameMatch = modelAndView.getViewName().equalsIgnoreCase("register");
        boolean modelMatch = (new Admin()).equals(modelAndView.getModel().get("admin"));
        
        return viewNameMatch && modelMatch;
    }

    public static Matcher<ModelAndView> adminModelAndView() {
        return new AdminModelAndViewMatcher();
    }
}
