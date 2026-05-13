package ar.edu.uns.cs.ed.tdas.tdacola;

import java.util.EmptyStackException;

public class ColaArregloCircular<E> implements Queue<E> {
   protected int tamaño;
   protected E[] datos; 
   protected int head;
   protected int tail;
   public ColaArregloCircular(int max){
    tamaño = 0;
    datos = (E[]) new Object[max];
    head = 0;
    tail = 0;
   }
   public ColaArregloCircular(){
    this(20);
   }
   public boolean isEmpty(){
    return head==tail;
   }
   public int size(){
    return tamaño;
   }
   public void enqueue(E item){
    if (size() == datos.length-1){
        E[] aux = (E[]) new Object[2*datos.length];
        for (int i = 0; i<datos.length;i++)
            aux[tamaño++] = this.dequeue();
        datos = aux;
    }
        datos[tail] = item;
        tail = (tail+1) % datos.length;
        tamaño++;
   }
   public E front(){
    if (isEmpty())
        throw new EmptyStackException();
    return datos[head];
   }
   public E dequeue(){
    E resultado = front();
    datos[head] = null;
    head = (head+1) % datos.length;
    tamaño--;
    return resultado;
   }
}
