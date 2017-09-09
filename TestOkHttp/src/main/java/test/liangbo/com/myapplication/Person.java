package test.liangbo.com.myapplication;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/4.
 */

public class Person {
    String name;

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void addChildren(Person child) {
        if(children==null)
        {
            children=new ArrayList<>();
        }
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public Person(String name) {

        this.name = name;
    }

    ArrayList<Person> children;
}
