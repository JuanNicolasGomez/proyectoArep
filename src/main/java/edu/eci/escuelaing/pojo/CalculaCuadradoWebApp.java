package edu.eci.escuelaing.pojo;

import edu.eci.escuelaing.annotations.Webapp;

public class CalculaCuadradoWebApp {

    @Webapp
    public String cuadrado(String num){
        int a = Integer.parseInt(num);

        String result = String.valueOf(a*a);
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Calcular cuadrado</h1>\n"
                + "<h2>Resultado: " + result + "</h2>"
                + "</body>\n"
                + "</html>\n";
    }
}
