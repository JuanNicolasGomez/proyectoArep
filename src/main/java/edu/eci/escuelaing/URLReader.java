package edu.eci.escuelaing;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class URLReader {
    public static void main(String[] args) throws Exception {
        URL google = new URL("https://www.google.com.co/search?q=hola&oq=hola&aqs=chrome..69i57j0l5.591j0j7&sourceid=chrome&ie=UTF-8#pedro");

        System.out.println(google.getProtocol());
        System.out.println(google.getAuthority());
        System.out.println(google.getHost());
        System.out.println(google.getPort());
        System.out.println(google.getPath());
        System.out.println(google.getQuery());
        System.out.println(google.getFile());
        System.out.println(google.getRef());

        Scanner input = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a url: ");
        String userInput = input.nextLine(); // Scans the next token of the input as an int.

        URL userURL = new URL(userInput);
        //once finished
        input.close();

        try (BufferedReader reader
                     = new BufferedReader(new InputStreamReader(userURL.openStream()))) {
            String inputLine = null;
            String fileContent="";
            while ((inputLine = reader.readLine()) != null) {
                fileContent = fileContent + inputLine + "\n";

            }
            usingBufferedWritter(fileContent);
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    public static void usingBufferedWritter(String fileContent) throws IOException
    {


        BufferedWriter writer = new BufferedWriter(new FileWriter("./urlInfo.html"));
        writer.write(fileContent);
        writer.close();
    }

}
