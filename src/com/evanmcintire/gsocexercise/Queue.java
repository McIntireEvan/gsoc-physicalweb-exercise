package com.evanmcintire.gsocexercise;

public class Queue<T> {
    T[] contents;

    public Queue() {
        contents = (T[])(new Object[1]);
    }

    /**
     * Add data to the queue.
     * This increases the internal array size by 1
     * and inserts the data at the end
     *
     * @param data The data to put into the Queue
     */
    public void put(T data) {
        //Create a new generic array with a new space at the end
        T[] newArray = (T[])(new Object[this.contents.length + 1]);

        //Copy over all the existing data
        for(int i = 0; i < this.contents.length; i++) {
            newArray[i] = this.contents[i];
        }

        //Add the new element and assign it to the object array
        newArray[this.contents.length] = data;
        this.contents = newArray;
    }

    /**
     * Retrieves the first element of the queue.
     * The element is then removed and the rest of the queue moves forward
     *
     * @returns The first element of the queue.
     */
    public T pop() {
        T returnData;

        //We can't get an element, so throw an error
        if(this.contents.length == 0) {
            throw new IndexOutOfBoundsException();
        }

        //Create a new array 1 smaller than our current array
        T[] newArray = (T[])(new Object[this.contents.length - 1]);

        //Copy over everything but the first element
        for(int i = 0; i < this.contents.length; i++) {
            newArray[i] = this.contents[i + 1];
        }
        returnData = this.contents[this.contents.length - 1];
        this.contents = newArray;

        return returnData;
    }

    /**
     * Retrieves the first element of the queue without removing it
     *
     * @returns The first element of the queue
     */
    public T peek() {
        //We can't get an element, so throw an error
        if(this.contents.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.contents[this.contents.length - 1];
    }
}