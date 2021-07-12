package com.linmu.Test;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;


/**
 * @author xxx_
 */
public class Main {
    public static void main(String[] args) {
        Test test = new Test("111", "222", "333");

    }

}


class Test implements Externalizable {
    private String data1;
    private String data2;
    private String data3;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(data1);
        out.writeObject(data3);
    }

    
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        data1 = (String) in.readObject();
        data3 = (String) in.readObject();
    }


    Test(String data1, String data2, String data3){
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    @Override
    public String toString() {
        return "Test{" +
                "data1='" + data1 + '\'' +
                ", data2='" + data2 + '\'' +
                ", data3='" + data3 + '\'' +
                '}';
    }


}
