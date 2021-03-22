package prikhozhaya;

import java.util.Arrays;

public class ArrayNum {
    double[] arrayNum;

    public double[] getArrayNum() {
        return arrayNum;
    }

    public void setArrayNum(double[] arrayNum) {
        this.arrayNum = arrayNum;
    }

    public ArrayNum() {
    }

    public double max (){
        return Arrays.stream(arrayNum).max().getAsDouble();
    }

    public double min (){
        return Arrays.stream(arrayNum).min().getAsDouble();
    }

    public double avg (){
        return Arrays.stream(arrayNum).average().getAsDouble();
    }


}
