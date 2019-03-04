package edu.eci.escuelaing;

import edu.eci.escuelaing.pojo.CalculaCuadradoWebApp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;
public class HttpServer {
    public static void main(String[] args) throws IOException {
        while(true) {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(new Integer(System.getenv("PORT")));
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
            Socket clientSocket = null;

            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));
                String inputLine, outputLine = "";


                if ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                }

                String[] tempArray = inputLine.split(" ");


                if (tempArray[1].equals("/")) {
                    outputLine = "HTTP/1.1 200 OK\r\n"
                            + "Content-Type: text/html\r\n"
                            + "\r\n"
                            + "<!DOCTYPE html>\n"
                            + "<html>\n"
                            + "<head>\n"
                            + "<meta charset=\"UTF-8\">\n"
                            + "<title>Title of the document</title>\n"
                            + "</head>\n"
                            + "<body>\n"
                            + "<h1>Home Page</h1>\n"
                            + "<h2>Try out another route: /cuadrado:45, /hola.png</h2>"
                            + "</body>\n"
                            + "</html>\n";

                }
                else if (tempArray[1].contains("hola.png")) {
                    out.write("HTTP/1.1 200 OK");
                    out.println("Content-Type: image/png");
                    out.println();
                    BufferedImage image = ImageIO.read(new File("." + tempArray[1]));
                    ImageIO.write(image, "PNG", clientSocket.getOutputStream());
                }else if (tempArray[1].contains("/cuadrado")){
                    String param = tempArray[1].split(":")[1];
                    AnnotationHandler annHandler = new AnnotationHandler();
                    outputLine = annHandler.handle(CalculaCuadradoWebApp.class,param);


                }


                out.println(outputLine);
                out.close();
                in.close();
                clientSocket.close();
                //serverSocket.close();
            }catch(Exception e){

                e.printStackTrace();
            }

            serverSocket.close();
        }
    }
}
