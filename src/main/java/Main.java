import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://olcha.uz/oz/product/view/smartfon-xiaomi-redmi-note-11-6-gb-128gb-grafitovo-seryy");
            System.out.println("URL is: "+url.toString());
            System.out.println("protocol: "+url.getProtocol());
            System.out.println("file name is: "+url.getFile());
            System.out.println("host is: "+url.getHost() );
            System.out.println("path is: "+url.getPath());
            System.out.println("port is: "+url.getPort());
            System.out.println("default port is: "+url.getDefaultPort());
            System.out.println("query is: "+url.getQuery());

            URLConnection urlConnection = url.openConnection();
            System.out.println(urlConnection.getContentType());
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())) ;
            String line;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }




        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
