package com.kraynov.ch5.propeditors;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyEditorBean {
    private byte[] bytes;
    private Class cls;
    private Boolean trueOrFalse;
    private List<String> stringList;
    private Date date;
    private Float floatValue;
    private File file;
    private InputStream stream;
    private Pattern pattern;
    private Properties properties;
    private String trimString;
    private URL url;
    private Locale locale;

    public void setBytes(byte[] bytes) {
        System.out.println("Adding " + bytes.length +" bytes");
        this.bytes = bytes;
    }

    public void setCls(Class cls) {
        System.out.println("Setting class: "+cls.getName());
        this.cls = cls;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Setting Boolean: "+trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("Setting string list with size: "+stringList.size());
        this.stringList = stringList;
    }

    public void setDate(Date date) {
        System.out.println("Setting date: "+date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("Setting Float value: "+floatValue);
        this.floatValue = floatValue;
    }

    public void setFile(File file) {
        System.out.println("Setting file: "+file.toString());
        this.file = file;
    }

    public void setStream(InputStream stream) {
        System.out.println("Setting stream: "+stream.toString());
        this.stream = stream;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("Setting pattern: "+pattern.toString());
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        System.out.println("Loaded properties: "+properties.size());
        this.properties = properties;
    }

    public void setTrimString(String trimString) {
        System.out.println("Setting trim string: "+trimString);
        this.trimString = trimString;
    }

    public void setUrl(URL url) {
        System.out.println("Setting url: "+url.toExternalForm());
        this.url = url;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
