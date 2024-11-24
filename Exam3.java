
public class Exam3 {

    public void white(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i * i);
        }
    }

    public void yellow(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j >= 0; j--) {
                System.out.println(i * j);
            }
        }
    }

    

    public void red(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j >= 0; j--) {
                for (int k = 0; k < 100; k++) {
                    System.out.println(i * j * k);
                }
            }
        }
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

    public static void testGenerics() {
        Integer[] t1arr = new Integer[]{2, 7, 10, 1, 8};
        // swap(t1arr, 0, 1);
        arrayPrinter(t1arr);
        String[] t2arr = new String[]{"he", "she", "it", "us", "them"};
        arrayPrinter(t2arr);
        t1arr = new Integer[]{42};
        arrayPrinter(t1arr);
        t1arr = new Integer[0];
        arrayPrinter(t1arr);
        t1arr = new Integer[]{2, 7, 10, 1, 8};
        swap(t1arr, 0, 1);
        arrayPrinter(t1arr);
        System.out.println(largest(t1arr));
    }

    public static void main(String[] args) {
        testGenerics();
    }
}
