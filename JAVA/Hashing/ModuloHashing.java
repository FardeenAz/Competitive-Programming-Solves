//DS Lab 3rd sem --> Hash searching

package com.Hashing;
public class ModuloHashing {
    public static int size=7;
    public static int[] arr=new int[size];
    public static void init(){
        for(int i=0;i<size;i++){
            arr[i]=-1;
        }
    }
    public static int linearProbe(int value){
        System.out.println("Using linear probe resolution");
        int key = value%size;
        int i=0;
        while(arr[key]==-1){
            key=(value+1)%size;
            if(arr[key]==-1){
                return key;
            }
            i++;
            if(i>size){return -1;};
        }
        return -1;
    }
//    public static int pseudoRandomProbe(int value){
//        System.out.println("Using pseudoRandom probe resolution");
//        int key = ((3*value)+5)%size;
//        int i=0;
//        while(arr[key]==-1){
//            key = ((3*value)+5)%size;;
//            if(arr[key]==-1){
//                return key;
//            }
//            i++;
//            if(i>size){return -1;};
//        }
//        return -1;
//    }

    public  static void insert(int value){
        int key = value%size;
        if(arr[key]==-1){
            arr[key]=value;
            System.out.println("Inserted !");
        }
        else{
            if(linearProbe(value)!=-1){
                arr[linearProbe(value)]=value;
            }
            else{
                System.out.println("not found!");
            }
        }
    }
    public static void search(int value){
        int key = value%size;
        if(arr[key]==value){
            System.out.println("found at "+ key+"th index");
        }
        else{
            if(linearProbe(value)!=-1){
                int tempKey=linearProbe(value);
                if(arr[tempKey]==value){
                    System.out.println("found at "+ tempKey+"th index");
                }
            }
            else{
                System.out.println("not found!");
            }
        }
    }
    public static void del(int value){
        int key = value%size;
        if(arr[key]==value){
            arr[key]=-1;
            System.out.println("Deleted !");
        }
        else{
            if(linearProbe(value)!=-1){
                int tempKey=linearProbe(value);
                if(arr[tempKey]==value){
                    arr[tempKey]=-1;
                    System.out.println("Deleted !");
                }
            }
            else{
                System.out.println("not found!");
            }
        }
    }
    public static void print(){
        for(int i=0;i<size;i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }
    public static void printItem(){
        for(int i=0;i<size;i++){
            if(arr[i]!=-1)System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }
    public static void main(String[] args) {
        init();
        System.out.println("initially");
        print();
       insert(65127);
       insert(74951);
       insert(84775);
       insert(54689);
       printItem();
    }
}
