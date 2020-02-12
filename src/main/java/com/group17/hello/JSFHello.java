package com.group17.hello;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name="managedBean")
@ViewScoped
public class JSFHello implements Serializable {
    private String text;

    public String getText() {
        String text2 = text+"$";
        return text2;
    }

    public void setText(String text) {
        this.text = text;
    }
}