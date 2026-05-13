package ar.edu.uns.cs.ed.tdas.tdapila;

import java.util.EmptyStackException;

public class PilaArreglo<E> implements Stack<E> {
   protected int tamaño;
   protected E[] datos; 
   public PilaArreglo(int max){
    tamaño = 0;
    datos = (E[]) new Object[max];
   }
   public PilaArreglo(){
    this(20);
   }
   public boolean isEmpty(){
    return tamaño==0;
   }
   public int size(){
    return tamaño;
   }
   public void push(E item){
    if (tamaño == datos.length){
        E[] aux = (E[]) new Object[2*datos.length];
        for (int i = 0; i<datos.length;i++)
            aux[tamaño++] = this.pop();
        datos = aux;
    }
    datos[tamaño++] = item;
   }
   public E top(){
    if (tamaño==0)
        throw new EmptyStackException();
    return datos[tamaño-1];
   }
   public E pop(){
    E resultado = top();
    datos[tamaño-1] = null;
    tamaño = tamaño-1;
    return resultado;
   }
}
