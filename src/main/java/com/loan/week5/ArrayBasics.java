package com.loan.week5;

public class ArrayBasics {
    public static void main(String[] args) {
        int[] a = new int[4];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;

        int[] b = {1,2,3,4};
        //travers
        for(int i=0; i<a.length;i++){
           // System.out.println(a[i]);
        }

        for(int i:a){
            //System.out.println(i);
        }

        //find Max
        int max=a[0];
        for(int i:a){
            if(i>max){
                max=i;
            }
        }
        System.out.println("max : "+max);
        //find min
        int min=a[0];
        for(int i:a){
            if(i<min){
                min=i;
            }
        }
        System.out.println("min : "+min);

    }
}
