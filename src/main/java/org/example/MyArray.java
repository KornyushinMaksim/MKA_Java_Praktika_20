package org.example;

import com.sun.jndi.ldap.ext.StartTlsResponseImpl;

import java.util.Arrays;
import java.util.Comparator;

public class MyArray <T> {
    T[] array;

    public MyArray() {
        this.array = (T[]) new Object[0];
    }

    public MyArray(T[] array) {
        this.array = array;
    }

    public void addItem(T item){
        T[] newArray = Arrays.copyOf(this.array, this.array.length + 1);
        newArray[this.array.length] = item;
        this.array = newArray;
    }

    public void fillRand(int size, iRandomaiser<T> randomaiser){
        T[] nArray = (T[]) new Object[size];
        for (int i = 0; i < size; i++){
            nArray[i] = randomaiser.randomItem();
        }
        this.array = nArray;
    }

    public T searchMaxMin(Comparator<T> comparator){
        T res = this.array[0];
        for (int i = 0; i < this.array.length; i++){
            if(comparator.compare(res, this.array[i]) > 0){
                res = this.array[i];
            }
        }
        return res;
    }

    public int average(iAverage<T> ave){
         int summ = 0;
        for (int i = 0; i < this.array.length; i++){
            summ += ave.average(this.array[i]);
        }
        return summ / this.array.length;
    }

    public void sort(Comparator<T> comparator){
        for (int j = 0; j < this.array.length; j++) {
            for (int i = 0; i < this.array.length - 1; i++) {
                if (comparator.compare(this.array[i], this.array[i + 1]) > 0) {
                    T tmp = this.array[i];
                    this.array[i] = this.array[i + 1];
                    this.array[i + 1] = tmp;
                }
            }
        }
    }

    public int search (T value, Comparator<T> comparator){
            return Arrays.binarySearch(this.array, value, comparator);
    }

    @Override
    public String toString() {
        String str = new String();
        for (T item : this.array){
            str += item + " ";
        }
        return str;
    }
}
