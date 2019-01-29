package edu.eci.escuelaing;

 import java.net.*;
import java.io.*;

public class EchoServer {

    private static String operation = "cos";
    private static boolean operationChanged = false;
    public static void main(String[] args) throws IOException {
        System.out.println("Servidor ejecutandose...");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:"+inputLine);

            //outputLine = "Respuesta"+ Math.pow(Double.parseDouble(inputLine),2);
            outputLine = "Respuesta"+ serverAnswer(inputLine);
            out.println(outputLine);
            if (outputLine.equals("Respuestas: Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static double serverAnswer(String inputLine){
        double ans = 0;
        if (inputLine.length()>4) {
            //System.out.println(inputLine.substring(0, 4));
            if (inputLine.substring(0,4).equals("fun:")){
                operation = inputLine.substring(4);
                operationChanged = true;
                //System.out.println(operation);
            }
        }
        if (operationChanged == true){
            operationChanged = false;
        }else{
            if(operation.equals("cos")){
                //System.out.println("FUNCTION CHANGED TO COS");
                ans = Math.cos(Double.parseDouble(inputLine));

            }else if(operation.equals("sin")){
                //System.out.println("FUNCTION CHANGED TO SIN");
                ans = Math.sin(Double.parseDouble(inputLine));

            }else if(operation.equals("tan")){
                //System.out.println("FUNCTION CHANGED TO TAN");
                ans = Math.tan(Double.parseDouble(inputLine));
            }
        }

        return ans;


    }
}
