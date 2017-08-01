package com.test;

public class TestClass {

    private static Link last;
    private static Link first;

    public static void main(String[] args) {

        //Inserting
        for(int i=0;i<5;i++){
            Link.insert(i+5);
        }
        Link.printList();

        //Deleting head
        Link.deletefromFirst();
        Link.printList();
        //Remove all element in the linkedlist that is great than a target value
        Link.deletefromtarget(7);
        Link.printList();
        //Deleting tail
        Link.deletefromLast();
        Link.printList();
    }


    protected  static class Link {
        private int data;
        private Link nextlink;

        public Link(int d1) {
            this.data = d1;
        }
        
        public static void insert(int d1) {
        	// 1. Append an element into the linkedlist
            Link a = new Link(d1);
            a.nextlink = null;
            if (first != null) {
                last.nextlink = a;
                last = a;
            } else {
                first = a;
                last = a;
            }
            System.out.println("Inserted -:"+d1);
        }

        public static void deletefromFirst() {
            if(null!=first)
            {
                System.out.println("Deleting -:"+first.data);
                first = first.nextlink;
            }
            else{
                System.out.println("No elements in Linked List");
            }
        }
        
        public static void deletefromLast() {
        	// 2. Remove the tail element from a linkedlist
        	Link temp = first;
        	if (first == null)
        	{
        		System.out.println("No elements in Linked List");
        	}
        	else if (first == last)
        	{
        		System.out.println("Deleting -:"+first.data);
        		first = null;
        	}
        	
            while(temp!=last)
            {
            	
            	
            	System.out.println(temp.data);
                if (temp.nextlink == last)
                {
                	last = temp;
                	last.nextlink = null;
                	break;
                }
                temp = temp.nextlink;
            }
            
        }
        
        
           public static void deletefromtarget(int nval) {
        	 //3. Remove all element in the linkedlist that is great than a target value
            Link temp = first;
            Link pre = first;
            while (temp != null) {
               if (temp.data > nval)
            	   {
            	   	if (temp.nextlink != null)
            	   	{
            	   		pre.nextlink = temp.nextlink;
            	   		temp = temp.nextlink;
            	   	}
            	   	else {
            	   		pre.nextlink = null;
            	   		temp = temp.nextlink;
            	   	}
            	   }
            	   else {
            		   pre=temp;
            		   temp = temp.nextlink;
            	   }
                
            }
            // recover last
            temp = first;
            while (temp != null) {          	
            	last=temp;
            	temp = temp.nextlink;
            }
           
        }
// function
        public static void printList() {
            System.out.println("Elements in the list are");
            System.out.println("-------------------------");
            Link temp = first;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.nextlink;
            }
        }
    }
}