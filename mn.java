package projfiles;

import java.io.*;
import java.util.*;
import java.lang.Math;

class mn{

    static List<Integer> cntr;
    static List<Integer> firstl;
    static List<String[]> dataset = new ArrayList<String[]>();

    //This function calculates the standard deviation
    public static double calculateSD(double numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }



    //this function will decide the cluster with closest centroid for the point 'a'
    public static int clusterDecide(int a){   // int a is the new record 
        int dis=0;
        int clst=0;



        return clst;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T,k,p;
        List<List<Integer>> cluster= new ArrayList<List<Integer>>(); // stores list of elements in array
        Set<Integer> first=new HashSet<Integer>();//stores the first random elements in each cluster

        dataset=new cls().readData();

        System.out.print("Enter the Number of records to be used:");
        T=Integer.parseInt(br.readLine());

        System.out.print("Enter value of k:");
        k=Integer.parseInt(br.readLine());

        System.out.print("Number of clusters are:");
        p=(int)Math.floor(T/k);
        System.out.println(p);

        
        Random r=new Random();

        //initialize each cluster
        for(int i = 0; i < p; i++)  {
            cluster.add(new ArrayList<Integer>());
        }

        while(first.size()<p){
            first.add((r.nextInt(T)+1));
        }

        System.out.println(first);

        firstl = new ArrayList<Integer>(first);
        // add the first random elements of each cluster in the cluster list
        for(int i=0;i<p;i++){
            cluster.get(i).add(firstl.get(i));
        }
        System.out.println(cluster);
        
        cntr = new ArrayList<Integer>(firstl);//list to store centroid
        int decClus = 0;    //The clustre to which the record will be assigned
        for(int i=0;i<T;i++){
            if(firstl.contains(i))
                continue;
            else{
                firstl.add(i);
                decClus=clusterDecide(i);
                cluster.get(decClus).add(i);
            }


        }

    }
}
