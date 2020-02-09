import java.util.ArrayList;
public class PuzzleJavaTest{
    public static void main(String[] args){
        PuzzleJava puzzle = new PuzzleJava();
        
        ArrayList numberShuffle = puzzle.printAll();

        ArrayList theShuffleGame = puzzle.nameShuffle();

        puzzle.alphabetShuffle();

        ArrayList randomArrayOfNumbers = puzzle.randomNumbers();

        puzzle.randomNumbersShuffled();

        puzzle.randomString();

        puzzle.randomStrings();
    }
}