package dev.dsa.java.advance.sorting;
import java.util.*;
//solve this problem using comparator
public class ClosestPointToOrigin {
    public static void main(String[] args) {
        DataPoints dp = new DataPoints();
        ArrayList<ArrayList<Integer>> distance = new ArrayList<>();
        ArrayList<Integer> d1= new ArrayList<>();
        d1.add(1);
        d1.add(3);
        distance.add(d1);
        ArrayList<Integer> d2= new ArrayList<>();
        d2.add(-2);
        d2.add(-2);
        distance.add(d2);
        ArrayList<Integer> d3= new ArrayList<>();
        d3.add(-1);
        d3.add(-1);
        distance.add(d3);
        ArrayList<Integer> d4= new ArrayList<>();
        d4.add(-2);
        d4.add(-1);
        distance.add(d4);
        dp.solve(distance,2);
    }
}
// use camparator to sort
class SortByDistanceFromOrigin implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        int res =  findDistance(o1) - findDistance(o2);
        return res;
    }

   public int  findDistance(ArrayList<Integer> A){
        int diff =  A.get(0)*A.get(0) + A.get(1)*A.get(1);
        return diff;
    }
}

class DataPoints{
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {

        Collections.sort(A, new SortByDistanceFromOrigin());

        ArrayList<ArrayList<Integer>> distance = new ArrayList<>();
        for(int i=0;i<B;i++){
            distance.add(A.get(i));
        }
        return distance;
    }
}
