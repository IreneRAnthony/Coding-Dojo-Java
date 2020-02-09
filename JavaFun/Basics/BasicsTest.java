import java.util.ArrayList;

public class BasicsTest {
    public static void main(String[] args){
        Basics basic = new Basics();
        Integer one = basic.oneToTwoHundredFiftyFive();

        Integer two = basic.oddNumbers();

        Integer sum = basic.printSum();

        int[] firstArray = {1,3,5,7,9,13};

        int[] first = basic.iteratingThroughAnArray(firstArray);

        Integer second = basic.findMax(firstArray);

        Integer avg = basic.getAverage(firstArray);

        ArrayList odd = basic.arrayWithOddNumbers();

        Integer greater = basic.greaterThanY(firstArray, 3);

        int[] squared = basic.squareTheValues(firstArray);

        int[] noNegatives = basic.eliminateNegativeNumbers(firstArray);

        int[] newArray = basic.maxMinAvg(firstArray);

        int[] shifting = basic.shiftingValues(firstArray);
     }
}