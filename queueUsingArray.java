package com.annotation.noXML;

class CustomQueue<T>{

    private Object [] array;
    private int frontPointer = 0;
    private int backPointer = 0;
    private final static int DEFAULT_SIZE = 5;


    public CustomQueue(int size){
        array = new Object[size];
    }

    public CustomQueue(){
        array = new Object[DEFAULT_SIZE];
    }

    public void add(T value){
        if(backPointer <= array.length-1)
            array[backPointer++] = value;
        else {
            Object[] newArray = new Object[backPointer * 2];
            for(int i=0; i< array.length;i++){
                newArray[i] = array[i];
            }
            array = newArray;
            array[backPointer++] = value;
        }
    }

    public Object remove(){
        return array[frontPointer++];
    }

    public Object peek(){
        return array[frontPointer];
    }

    public void print(){
        for(Object i: array) {
            if(i == null) continue;
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void location(){
        System.out.println("Front-> "+frontPointer+" back-> "+ backPointer);
    }

}

public class queueUsingArray {
    public static void main(String[] args) {

        CustomQueue<Integer> queue = new CustomQueue<>();
        queue.add(5);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        queue.print();
        queue.location();
        System.out.println("Old-> "+queue.peek());

        queue.remove();
        System.out.println("New-> "+ queue.peek());
        queue.location();


    }
}
