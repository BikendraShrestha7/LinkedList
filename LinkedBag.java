/*
 * **********************************************
 * San Francisco State University
 * CSC 220 - Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartA;

import java.util.HashSet;
import java.util.Set;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (firstNode == null) {
            firstNode = newNode; // First element in the list
        } else {
            Node lastNode = firstNode;
            while (lastNode.next != null) {
                lastNode = lastNode.next; // Traverse to the last node
            }
            lastNode.next = newNode; // Append new node at the end
        }

        numberOfEntries++;
        return true;
    }

    @Override
    public boolean removeAllOccurrences(T[][] entries) {
        if (entries == null || entries.length == 0) {
            return false;
        }

        // Step 1: Convert 2D array to a HashSet to remove duplicates
        Set<T> uniqueEntries = new HashSet<>();
        for (T[] row : entries) {
            for (T item : row) {
                uniqueEntries.add(item);
            }
        }

        // Step 2: Remove all occurrences from the linked list
        removeOccurrences(uniqueEntries);

        return true;
    }

    // Helper method to iteratively remove nodes while preserving order
    private void removeOccurrences(Set<T> entries) {
        Node dummy = new Node(null, firstNode); // Dummy node to handle head removal
        Node prev = dummy;
        Node current = firstNode;

        while (current != null) {
            if (entries.contains(current.data)) {
                prev.next = current.next; // Remove node
                numberOfEntries--;
            } else {
                prev = current; // Move forward if not removed
            }
            current = current.next;
        }

        firstNode = dummy.next; // Update first node reference
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;  // Ensure correct order
        Node currentNode = firstNode;
        while (currentNode != null) {
            result[index++] = currentNode.data;
            currentNode = currentNode.next;
        }
        return result;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}
