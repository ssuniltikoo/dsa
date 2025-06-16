package dev.dsa.java.basic;

import java.util.*;

public class TestComapreClass {
    public static void main(String[] args) {
        List<CompareTest> list = new ArrayList<CompareTest>();
        list = Arrays.asList(
                new CompareTest(1,100),
                new CompareTest(200,200),
                new CompareTest(30,300) ,
                new CompareTest(4,400) ,
                new CompareTest(5234,500) ,
                new CompareTest(6,600)
        );
        Collections.sort(list,new sortByEmploeeNumberDesending());
        list.forEach(a-> System.out.println(a.getNumber()));






    }
}

class CompareTest implements Comparable<CompareTest> {
    private int number;
    private int id;

    public CompareTest(int number, int id) {
        this.number = number;
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(CompareTest o) {
        return  o.number - this.number ;
    }

}

class IdCompare implements Comparator<CompareTest>{


    @Override
    public int compare(CompareTest o1, CompareTest o2) {
        return o1.getId() - o2.getId();
    }
}


class sortByEmploeeNumberDesending implements  Comparator<CompareTest>{


    @Override
    public int compare(CompareTest o1, CompareTest o2) {
        return o2.getNumber() - o1.getNumber();
    }
}