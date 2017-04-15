package com.kraynov.ch6.declar;

public class МуВеаn {
    private MyDependency dep;

    public void execute(){
        dep.foo();
        dep.bar();
    }

    public void setDep(MyDependency dep){
        this.dep = dep;
    }
}
