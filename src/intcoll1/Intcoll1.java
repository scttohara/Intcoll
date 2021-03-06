package intcoll1;

/**
 *
 * @author scttohara
 */

public class Intcoll1 {

    private int[] c;

    //Makes the collection empty and insures it has capacity for 500 integers.
    public Intcoll1() {
        c = new int[501];
        c[0] = 0;
    }

    //Makes a collection the length of the parameter passed plus one.
    public Intcoll1(int i) {
        c = new int[i + 1];
        c[0] = 0;
    }

    //example A == c B == obj A.copy(B) 
    //all the capacity and integers in B should end up in A. B should
    //not be changed at all.
    public void copy(Intcoll1 obj) {
        if (this != obj) {
            c = new int[obj.c.length];
            int j = 0;
            while (obj.c[j] != 0) {
                c[j] = obj.c[j]; j++;
            }
            c[j] = 0;
        }
    }

    //returns true if i exist in the collection and false otherwise.
    //i has to be greater than zero.
    public boolean belongs(int i) {
        int j = 0;
        while ((c[j] != 0) && (c[j] != i)) {
            j++;
        }
        return ((i > 0) && (c[j] == i));
    }

    //i must be greater than 0.
    //i is inserted into collection if it isn't there already.
    public void insert(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i)) {
                j++; //if i doesnt equal zero
            }
            if (c[j] == 0) {
                if (j == c.length - 1) {
                    
                    int[] tempArray = new int[c.length * 2];

                    for (int w = 0; w < c.length; w++) {
                        tempArray[w] = c[w];
                    }

                    c = tempArray;

                }
                c[j] = i; c[j + 1] = 0;
            }
        }
    }

    //i must be greater than 0 (zero).
    //if i is in the collection omit removes it.
    //if i doesnt exist in the collection omit does nothing.
    public void omit(int i) {
        if (i > 0) {
            int j = 0;
            while ((c[j] != 0) && (c[j] != i)) {
                j++;
            }
            if (c[j] == i) {
                int k = j + 1;
                while (c[k] != 0) {
                    k++;
                }
                c[j] = c[k - 1];
                c[k - 1] = 0;
            }
        }
    }

    //returns the number of integers in the collection before 0 (zero).
    public int get_howmany() {
        int j = 0, howmany = 0;

        while (c[j] != 0) {
            howmany++;
            j++;
        }
        return howmany;
    }

    //moves through array and prints integers that arent 0 (zero). Once it hits 
    //zero it stops without printing zero.
    public void print() {
        int j = 0;
        System.out.println();
        while (c[j] != 0) {
            System.out.println(c[j]);
            j++;
        }
    }

    //returns true if the integers in the array c are exactly the same as the
    //integers in obj. Returns false otherwise.
    public boolean equals(Intcoll1 obj) {
        int j = 0;
        boolean result = true;
        while ((c[j] != 0) && result) {
            result = obj.belongs(c[j]); j++;
        }
        j = 0;
        while ((obj.c[j] != 0) && result) {
            result = belongs(obj.c[j]); j++;
        }
        return result;
    }
}
