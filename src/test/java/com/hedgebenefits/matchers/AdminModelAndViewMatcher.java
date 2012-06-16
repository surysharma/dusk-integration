package com.hedgebenefits.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.springframework.web.servlet.ModelAndView;

public class AdminModelAndViewMatcher extends TypeSafeMatcher<ModelAndView> {

    private static ModelAndView expectedModelAndView;

    @Override
    public void describeTo(Description description) {
        description.appendValue(expectedModelAndView);
    }

    @Override
    public boolean matchesSafely(ModelAndView modelAndView) {
        return modelAndView.getViewName().equals(expectedModelAndView.getViewName())
                && modelAndView.getModel().equals(expectedModelAndView.getModel());
    }

    public static Matcher<ModelAndView> adminModelAndView(ModelAndView modelAndView) {
        expectedModelAndView = modelAndView;
        return new AdminModelAndViewMatcher();
    }
}
