package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import static java.util.stream.Collectors.joining;
import static javax.swing.UIManager.get;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Kata6 {

    public static void main(String[] args) throws MalformedURLException, JAXBException, IOException {
        Random r = new Random();
        
        URL url = new URL("https://api.breakingbadquotes.xyz/v1/quotes/5");
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(read(url), JsonArray.class)
                    .get(r.nextInt(5)).getAsJsonObject();
                              
        IamTheOneWhoKnocks quotes = gson.fromJson(jsonObject, IamTheOneWhoKnocks.class);
        System.out.println(quotes.toString() + "\n");
        
        JAXBContext context = JAXBContext.newInstance(IamTheOneWhoKnocks.class);
        
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(quotes, System.out);
    }
    
    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }           
    }
}