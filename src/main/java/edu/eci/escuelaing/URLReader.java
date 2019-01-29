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
        /*try (BufferedReader reader
                     = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                 System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }*/

    }

}
