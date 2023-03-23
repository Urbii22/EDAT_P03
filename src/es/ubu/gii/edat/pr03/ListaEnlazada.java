package es.ubu.gii.edat.pr03;

import java.util.*;

public class ListaEnlazada<E> extends AbstractList<E> {

    protected Nodo<E> priemro;
    protected Nodo<E> ultimo;
    private int tamano;



    public ListaEnlazada() {
        tamano = 0;
        this.priemro = null;
        this.ultimo = null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= tamano) {
            throw new IndexOutOfBoundsException("indice fure del limite del array");
        }
        Nodo<E> nodo = this.priemro;
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
            this.priemro = nuevo;
        }else{
            this.ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        tamano ++;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= tamano) {
            throw new IndexOutOfBoundsException("indice fure del limite del array");
        }
        Nodo<E> nodo = this.priemro;
        Nodo<E> anterior = null;
        for (int i = 0; i < index; i++) {
            anterior = nodo;
            nodo = nodo.siguiente;
        }
        if (nodo == this.priemro) {
            this.priemro = nodo.siguiente;
        }else {
            anterior.siguiente = nodo.siguiente;
        }
        if (nodo == this.ultimo) {
            this.ultimo = nodo.siguiente;
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
        this.priemro = null;
        this.ultimo = null;
    }
    //TODO hacer todos los metodos a sobreescribir

    //el metood clear pondrá la lista donde guardo los nodos a 0, null.
}
