import java.util.HashMap;
import java.util.Set;

public class TrackList{
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Hello World", "Hello World, programmed to work and not to feel. Not sure if this is even real, Hello World.");
        trackList.put("The Night We Met", "I am not the only traveler, who has not repaid his debts.");
        trackList.put("Dream Dream Dream", "Your heart can heal the pain.");
        trackList.put("Shelter", "But they will carry on for us. It's a long way forward but wait for me, I'll give them shelter as you've done for me.");

        String HelloWorld = trackList.get("Hello World");
        
        Set<String> keys = trackList.keySet();
        for(String key: keys){
            System.out.println(key);
            System.out.println(trackList.get(key));
        }
    }
}