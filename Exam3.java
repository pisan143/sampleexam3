import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Exam3 {

    // O(n) time complexity - single loop from 0 to n
    public void white(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i * i);
        }
    }

    // O(n^2) time complexity - nested loops from 0 to n
    public void yellow(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j >= 0; j--) {
                System.out.println(i * j);
            }
        }
    }

    // O(n^2) time complexity - nested loops from 0 to n
    // The third loop with k is O(1) time complexity
    public void red(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j >= 0; j--) {
                for (int k = 0; k < 100; k++) {
                    System.out.println(i * j * k);
                }
            }
        }
    }

    // O(n^2) time complexity - nested loops from 0 to n
    public void green(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println(j % i);
            }
        }
    }

    // O(n) time complexity - 2 x single loop from 0 to n
    public void purple(int[] myArray) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < myArray.length; i++) {
            sum += myArray[i];
        }
        for (int i = 0; i < myArray.length; i++) {
            product *= myArray[i];
        }
        System.out.println(sum + " " + product);
    }

    // O(log(n)) time complexity - i is doubled each iteration
    // The loop runs log(n) times
    public void blue(int n) {
        for (int i = 1; i < n; i *= 2) {
            System.out.println("Hello");
        }
    }

    // O(n) time complexity - single loop from 0 to n
    public int orange(int n) {
        if (n == 0) {
            return 0;
        }
        return n + orange(n - 1);
    }

    // O(2^n) time complexity - recursive calls for n-1 and n-2
    public int pink(int n) {
        if (n < 2) {
            return n;
        }
        return pink(n - 1) + pink(n - 2);
    }

    // O(n^2) time complexity - nested loops
    // Inner loop is O(n) time complexity
    // Outer loop worst case is called n times
    public void brown(int[] arr) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    // O(n) time complexity - 3 x single loop from 0 to n
    public int[] black(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    public static <T> void arrayPrinter(T[] arr) {
        System.out.print("[");
        if (arr.length > 0) {
            System.out.print(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("]");
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> T largest(T[] arr) {
        T maxV = arr[0];
        for (T val : arr) {
            if (maxV.compareTo(val) < 0) {
                maxV = val;
            }
        }
        return maxV;
    }

    public int numUniqueSet(int[] arr) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int val : arr) {
            seen.add(val);
        }
        return seen.size();
    }

    public int numUniqueSort(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        Collections.sort(arr);
        int count = 1;
        int current = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) != current) {
                count++;
                current = arr.get(i);
            }
        }
        return count;
    }

    public int numUniqueLimited(int[] arr) {
        boolean[] seen = new boolean[201];
        for (int num : arr) {
            seen[num + 100] = true;
        }
        int count = 0;
        for (boolean val : seen) {
            if (val) {
                count++;
            }
        }
        return count;
    }

    public int maxLength(Set<String> arr) {
        int mx = 0;
        for (String s : arr) {
            mx = Math.max(mx, s.length());
        }
        return mx;
    }

    public int contains3(List<String> arr) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String s : arr) {
            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                counts.put(s, 1);
            }
        }
        int total = 0;
        for (String s : counts.keySet()) {
            if (counts.get(s) == 3) {
                total++;
            }
        }
        return total;
    }

    public int maxOccurrences(List<String> arr) {
        if (arr.size() == 0) {
            return 0;
        }
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String s : arr) {
            if (counts.containsKey(s)) {
                counts.put(s, counts.get(s) + 1);
            } else {
                counts.put(s, 1);
            }
        }
        int bestScore = 0;
        for (String s : counts.keySet()) {
            if (counts.get(s) > bestScore) {
                bestScore = counts.get(s);
            }
        }
        return bestScore;
    }

    public boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int lengthOfLongestSorted(int[] arr) {
        int mx = 0;
        int current = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                current++;
            } else {
                mx = Math.max(mx, current);
                current = 1;
            }
        }
        return Math.max(mx, current);
    }

    public int[] zip(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            result[k] = a[i];
            k++;
            result[k] = b[j];
            k++;
            i++;
            j++;
        }
        while (i < a.length) {
            result[k] = a[i];
            k++;
            i++;
        }
        while (j < b.length) {
            result[k] = b[j];
            k++;
            j++;
        }
        return result;
    }

    public static void testGenerics() {
        Integer[] t1arr = new Integer[] { 2, 7, 10, 1, 8 };
        // swap(t1arr, 0, 1);
        arrayPrinter(t1arr);
        String[] t2arr = new String[] { "he", "she", "it", "us", "them" };
        arrayPrinter(t2arr);
        t1arr = new Integer[] { 42 };
        arrayPrinter(t1arr);
        t1arr = new Integer[0];
        arrayPrinter(t1arr);
        t1arr = new Integer[] { 2, 7, 10, 1, 8 };
        swap(t1arr, 0, 1);
        arrayPrinter(t1arr);
        System.out.println(largest(t1arr));
    }

    public static void main(String[] args) {
        testGenerics();
    }
}
