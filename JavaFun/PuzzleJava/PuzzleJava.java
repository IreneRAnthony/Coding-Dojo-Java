import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.Array;
import java.util.List;
public class PuzzleJava {
    public ArrayList printAll(){
        int[] Arr = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        ArrayList < Integer > y = new ArrayList <Integer> ();
        for(int i = 0; i < Arr.length; i++){
            sum += Arr[i];
            int newArr[];
            if(Arr[i] > 10){
                y.add(Arr[i]);
            }
        }
        System.out.println(sum);
        return y;
    }
    
    public ArrayList nameShuffle(){
        ArrayList <String> names = new ArrayList <String> ();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        ArrayList <String> newArray = new ArrayList<String>();
        Collections.shuffle(names);
        for(String name: names){
            System.out.print(name + " ");
            if (name.length() > 5){
                newArray.add(name);
            }
        }
        System.out.println(newArray);
        return newArray;
    }

    public void alphabetShuffle(){
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> shuffledAlphabet = new ArrayList<String>();
        for(int i = 0; i < alphabet.length; i++){
            shuffledAlphabet.add(alphabet[i]);
        }
        Collections.shuffle(shuffledAlphabet);
        if(shuffledAlphabet.get(0) == "a" || shuffledAlphabet.get(0) == "e" || shuffledAlphabet.get(0) == "i" || shuffledAlphabet.get(0) == "o" || shuffledAlphabet.get(0) == "u"){
            System.out.println(shuffledAlphabet.get(shuffledAlphabet.size() - 1));
            System.out.println("Congratulations, it's a vowel.");
            System.out.print(shuffledAlphabet.get(0));
        }
        else {
            System.out.println(shuffledAlphabet.get(shuffledAlphabet.size() - 1));
            System.out.print(shuffledAlphabet.get(0));
        }
    }

    public ArrayList randomNumbers(){
        ArrayList <Integer> random = new ArrayList<Integer>();
        Random rand = new Random();
        int i = 0;
        while(i < 11){
            int randomNum = rand.nextInt((100 - 55) + 1) + 55;
            random.add(randomNum);
            i++;
        }
        System.out.println(random);
        return random;
    }

    public void randomNumbersShuffled(){
        ArrayList <Integer> shuffled = new ArrayList<Integer>();
        Random rand = new Random();
        int i = 0;
        while(i < 11){
            int randomNum = rand.nextInt((100 - 55) + 1) + 55;
            shuffled.add(randomNum);
            i++;
        }
        int max = shuffled.get(0);
        int min = shuffled.get(0);
        Collections.sort(shuffled);
        for(int j = 0; j < shuffled.size(); j++){
            if(max < shuffled.get(j)){
                max = shuffled.get(j);
            }
            if(min > shuffled.get(j)){
                min = shuffled.get(j);
            }
        }
        System.out.println(shuffled);
        System.out.println("Max:" + max);
        System.out.println("Min:" + min);
    }

    public void randomString(){
        String newString = "";
        String LibraryString = "abcdefghijklmnopqrstuvxyz";
        Random rand = new Random();
        for(int i = 0; i < 6; i++){
            int number = rand.nextInt(25);
            char newCh = LibraryString.charAt(number);
            newString += newCh;
        }
        System.out.println(newString);
    }

    public void randomStrings(){
        ArrayList<String> newArray = new ArrayList<String>();
        int j = 0;
        String newString = "";
        String LibraryString = "abcdefghijklmnopqrstuvxyz";
        int stringLength = 6;
        Random rand = new Random();
        for(int i = 0; i < 6; i++){
            int number = rand.nextInt(25);
            char newCh = LibraryString.charAt(number);
            newString += newCh;
        }
        while(j < 11){
            newArray.add(newString);
            j++;
        }
        System.out.println(newArray);
    }
}