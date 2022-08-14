import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Post;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PostMain {
    public static void main(String[] args) throws IOException {

        GsonBuilder gsonBuilder= new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        URL url = null;
        File post = new File("src/main/resources/posts.txt");
        try(Writer writer = new FileWriter(post)) {
            url = new URL("https://jsonplaceholder.typicode.com/posts?id=1");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            Post[] postArray = gson.fromJson(bufferedReader,Post[].class);
            writer.write(gson.toJson(postArray));


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
