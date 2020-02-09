import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Basics {
    public Integer oneToTwoHundredFiftyFive() {
        int i = 1;
        while (i < 256) {
            System.out.println(i);
            i++;
        }
        return i;
    }

    public Integer oddNumbers() {
        int i = 1;
        while (i < 256) {
            System.out.println(i);
            i = i + 2;
        }
        return i;
    }

    public Integer printSum() {
        int i = 0;
        int sum = 0;
        while (i < 256) {
            System.out.println("New Number:" + i);
            i++;
            sum = sum + i;
            System.out.println("Sum:" + sum);
        }
        return sum;
    }

    public int[] iteratingThroughAnArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        return arr;
    }


    public Integer findMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
        return max;
    }

    public Integer getAverage(int[] arr) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            sum += arr[i];
        }
        final int avg = sum / count;
        System.out.println(avg);
        return avg;
    }

    public ArrayList arrayWithOddNumbers() {
        ArrayList < Integer > y = new ArrayList <Integer> ();
        int i = 1;
        while (i < 256) {
            y.add(i);
            i += 2;
        }
        System.out.println(y);
        return y;
    }

    public Integer greaterThanY(int[] arr, int y) {
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > y) {
                a++;
            }
        }
        System.out.println(a);
        return a;
    }

    public int[] squareTheValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] eliminateNegativeNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] maxMinAvg(int[] arr) {
        int sum = 0;
        int counter = 0;
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
            sum += arr[i];
            counter++;
        }
        int avg = sum / counter;
        int[] array;
        array = new int[3];
        array[0] = max;
        array[1] = min;
        array[2] = avg;
        System.out.println(Arrays.toString(array));
        return array;
    }

    public int[] shiftingValues(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i - 1] = arr[i];
            arr[arr.length - 1] = 0;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}