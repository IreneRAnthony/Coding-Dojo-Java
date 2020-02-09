import java.util.ArrayList;

class NotAnIntegerException extends Exception {}
class ExceptionList {
    public void listOfExceptions() throws NotAnIntegerException {
        ArrayList < Object > myList = new ArrayList < Object > ();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
            }
            catch (ClassCastException e){
                System.out.println("Not an integer");
            }
        }
    }
}

public class ExceptionListTest {
    public static void main(String[] args) {
        ExceptionList list = new ExceptionList();
        list.listOfExceptions();
    }
}