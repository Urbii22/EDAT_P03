package es.ubu.gii.edat.pr03;

import java.util.*;

public class ListaEnlazada<E> extends AbstractList<E> {

    protected Nodo<E> primero;
    protected Nodo<E> ultimo;
    private int tamano;



    public ListaEnlazada() {
        tamano = 0;
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= tamano) {
            throw new IndexOutOfBoundsException("indice fuera del limite del array");
        }
        Nodo<E> nodo = this.primero;
        for (int i = 0; i < index; i++) {
            nodo = nodo.siguiente;
        }
        return nodo.dato;
    }
    @Override
    public int size() {
        return tamano;
    }

    @Override
    public boolean add(E elemento) {
        Nodo<E> nuevo = new Nodo<>(elemento);
        if (tamano == 0) {
            this.primero = nuevo;
        }else{
            this.ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        tamano ++;
        return true;
    }

    @Override
    public E remove(int index) {
        //verifico que el indice no está fuera de nustra lista.
        if (index < 0 || index >= tamano) {
            throw new IndexOutOfBoundsException("indice fuera del limite del array");
        }
        //nodo actual
        Nodo<E> nodo = this.primero;
        //nodo anterior al actual
        Nodo<E> anterior = null;

        for (int i = 0; i < index; i++) {
            anterior = nodo;
            nodo = nodo.siguiente;
        }

        if (nodo == this.primero) {
            this.primero = nodo.siguiente;
        }else {
            anterior.siguiente = nodo.siguiente;
        }
        tamano --;
        return nodo.dato;
    }
    protected class Nodo<E> {
        E dato;
        Nodo<E> siguiente;
        public Nodo(E dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    public void clear(){
        tamano = 0;
        this.primero = null;
        this.ultimo = null;
    }
    protected class iterdaor implements ListIterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }
    }
    //TODO hacer todos los metodos a sobreescribir

    //el metood clear pondrá la lista donde guardo los nodos a 0, null.
}
