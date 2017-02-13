package com.kraynov.ch5.propeditors;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws java.lang.IllegalArgumentException{
        String[] name = text.split("\\s");
        Name result = new Name(name[0], name[1]);
        setValue(result);
    }
}
