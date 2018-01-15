package com.au.threading;

import java.util.LinkedList;

public class ProducersConsumers {
	
	 LinkedList<Integer> list = new LinkedList<>();
     int capacity = 5;

     
     public void produce() throws InterruptedException
     {
         int value = 0;
         while (true)
         {
             synchronized (this)
             {
                 
                 
                 while (list.size()==capacity)
                     wait();
                   System.out.println("Producer produced-"
                                               + value);

        
                 list.add(value++);
                 notify();
                 Thread.sleep(1000);
             }
         }
     }

     // Function called by consumer thread
     public void consume() throws InterruptedException
     {
         while (true)
         {
             synchronized (this)
             {
                 
              
                 while (list.size()==0)
                     wait();

    
                 int val = list.removeFirst();

                 System.out.println("Consumer consumed-"
                                                 + val);

                 
                 notify();

                 
                 Thread.sleep(1000);
             }
         }
     }
 }


