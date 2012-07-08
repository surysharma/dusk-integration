package com.hedgebenefits.propertyeditors;

import com.hedgebenefits.domain.Right;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 08/07/2012
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class RightsPropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Right right = (Right) getValue();
        if (right != null) {
            return right.getName();
        }
        return super.getAsText();
    }

    @Override
    public void setAsText(String rightStr) throws IllegalArgumentException {
        setValue(new Right(rightStr));
    }


}
