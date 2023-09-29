package com.example.precadastro.PreCadastro.EstruturasDados;

public class Fila<T> {
    private Node<T> inicio;
    private Node<T> fim;

    public void adicionar(T elemento) {
        Node<T> novoNo = new Node<>(elemento);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
    }

    public T retirar() {
        if (isEmpty()) {
            return null;
        }
        T elemento = inicio.getElemento();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;
        }
        return elemento;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    private static class Node<T> {
        private T elemento;
        private Node<T> proximo;

        public Node(T elemento) {
            this.elemento = elemento;
        }

        public T getElemento() {
            return elemento;
        }

        public Node<T> getProximo() {
            return proximo;
        }

        public void setProximo(Node<T> proximo) {
            this.proximo = proximo;
        }
    }
}

