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
        //verifico que el índice no está fuera de nuestra lista.
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
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public E next() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void set(Object o) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void add(Object o) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
