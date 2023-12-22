public class LinkedItem<T> // This method is used to implement linked list and its attributes accordingly 
{
    private T value;//Creating two instances as the question asked us to di 
    private LinkedItem<T> next;

    public LinkedItem() //Setting the default to null
    {
        this.value = null;
        this.next = null;
    }

    public LinkedItem(T value) //Adding in the value 
    {
        this.value = value;
        this.next = null;
    }

    public T getValue() //Getter method for value
    {
        return value;
    }

    public void setValue(T value) //Setter method
    {
        this.value = value;
    }

    public LinkedItem<T> getNext() //Gets next element from the LinkedItem
    {
        return next;
    }

    public void setNext(LinkedItem<T> next) //Gets next element from the LinkedItems next
    {
        this.next = next;
    }
}
