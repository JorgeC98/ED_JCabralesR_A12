/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad.pkg12;

/**
 *
 * @author JorgeRicardo
 */
public class Deque <T> {
    private DLNode<T> front;
    private DLNode<T> rear;
    private int size;
    
    Deque(){
        front = rear = null;
        size = 0;
    }
    
    Deque(T d){
        DLNode<T> node = new DLNode<>(d);
        front = rear = node;
        size= 1;        
    }
    
    public void enqueueFront(T d){
        DLNode<T> node = new DLNode<>(d);
        if (isEmpty()){
            front = rear = node;
        } else {
            node.next = front;
            front.back = node;
            front = node;
        }
        size++;
    }
    
    public void enqueueRear(T d){
        if (isEmpty()){
            enqueueFront(d);
        } else {
            DLNode<T> node = new DLNode<>(d);
            rear.next = node;
            node.back = rear;
            rear = node;
            size++;
        }
    }
    
    public T dequeueFront(){
        if (!isEmpty()){
            DLNode<T> fd = front;
            front = front.next;
            front.back = null;
            fd.next = null;
            size--;
            return fd.data;
        } else {
            return null;
        }
    }
    
    public T dequeueRear(){
        if (!isEmpty()){
            DLNode<T> rd = rear;
            rear=rear.back;
            rear.next=null;
            rd.back=null;
            size--;
            return rd.data;
        } else {
            return null;
        }
    }
    
    public T getFront(){
        return front.data;
    }
    
    public T getRear(){
        return rear.data;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void clearDeque(){
        front = rear=null;
        size = 0;
    }
    
    public void showDeque(){
        DLNode<T> p = front;
        while (p != null){
            p.print();
            p = p.next;
        }
    }
}
