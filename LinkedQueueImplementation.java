/*
 * Name: Suvanga Dhakal
 * Lab: Creating custom Queue
 * 
 */


import java.util.*;
//importing all java utility library
public class LinkedQueueImplementation<T> implements QueueInterface<T> //We were allready given premeditated methods and stubs 
{
	private LinkedItem<T> head;//The front of the queue and so on is firtsly instantiated as instance variable 
	private LinkedItem<T> tail;
	private int Count;//The position of queue 
	private int maxCapacity;//The maximum capacity of queue
	
	
    public LinkedQueueImplementation() 
    {
        this.head = null;
        this.tail = null;
        this.Count = 0;
        this.maxCapacity = 10; // Default set to 10
    }
	  public LinkedQueueImplementation(int capacity) 
	{
        this.head = null;
        this.tail = null;
        this.Count = 0;
        this.maxCapacity = capacity;
    }
	  
	  public int size() {
			// TODO Auto-generated method stub
		  return Count;
		}  
	  @Override
		public boolean isEmpty()
	  {
		  if(Count==0) 
		  {
			  return true;  
			  
		  }
		  else 
		  {
			  return false;
		  }
		}
	  
	public void enqueue(T item) throws QueueOverflowException //This method is add method for our custom queue
	{
		   if (isFull()) //checks if it is full, and if it is it will sned a it is full exception 
			   if (isFull()) {
		            resize(maxCapacity * 2); // Double the capacity
		        }

	        LinkedItem<T> newItem = new LinkedItem<>(item);//New item named Linked item is created 
	        if (isEmpty()) {
	            head = newItem;
	            tail = newItem;
	        } else {
	            tail.setNext(newItem);
	            tail = newItem;
	        }

	        Count++;
		
		
	}

	@Override
	public boolean isFull() //This was optional, but I still added it, this will check if it is full  
	{
		 if (Count == maxCapacity)
		     {
		         return true;
		     } 
		 else
		 	{
		        return false;
		   	}
	}

	
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		  if (isEmpty())//Shows this exception if it is empty
		  {
	            throw new QueueUnderflowException("Queue is empty. Could not remove item");
	        }

	        T item = head.getValue();//setting the head
	        head = head.getNext();//getting the next position for head

	        if (head == null) {
	            tail = null; // If the queue is now empty we will put this 
	        }

	        Count--;//As we deque it starts decreasing the counter

	        return item;
	}
	private void resize(int newCapacity) {
        newCapacity = newCapacity;
        
    }
}
	