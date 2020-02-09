public class StringManipulator {
    String trimAndConcat(String A, String B){
        String trimmedA = A.trim();
        String trimmedB = B.trim();
        String concatenated = trimmedA.concat(trimmedB);
        return concatenated;
    }

    Integer getIndexOrNull(String C, char A) {
        int search = C.indexOf(A);
        return search;
    }

    Integer getIndexOrNull(String D, String E){
        int search = D.indexOf(E);
        return search;
    }

    String concatSubstring(String E, int Begin, int End, String F){
        String halfString = E.substring(Begin, End);
        String newString = halfString.concat(F);
        return newString;
    }
}