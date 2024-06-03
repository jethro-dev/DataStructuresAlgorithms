package com.jethroau;

import com.jethroau.dsa.datastructures.list.DoublyLinkedList;
import com.jethroau.dsa.datastructures.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new DoublyLinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println(list); // Output: 1 2 3

        list.unshift(0);
        System.out.println(list); // Output: 0 1 2 3

        list.insertAt(2, 5);
        System.out.println(list); // Output: 0 1 5 2 3

        list.shift();
        System.out.println(list); // Output: 1 5 2 3

        list.pop();
        System.out.println(list); // Output: 1 5 2

        list.removeAt(1);
        System.out.println(list);; // Output: 1 2

        System.out.println(list.contains(2)); // Output: false


    }
}