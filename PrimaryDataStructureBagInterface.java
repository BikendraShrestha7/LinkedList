/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PrimaryDataStructureBagInterface.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment03PartA;

public interface PrimaryDataStructureBagInterface<T> {

    public int getCurrentSize();

    public boolean isEmpty();

    public boolean add(T newEntry);

    public boolean removeAllOccurrences(T[][] entries);

    public T[] toArray();
}
