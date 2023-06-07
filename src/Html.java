import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Html {
    public String Head;
    public String Body;

    public Html() {
        //Head Estandar
        this.Head = "<head>" +
                        "<title>Tabla de Estudiantes</title>" +
                        "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>" +
                    "</head>";
        this.Body = "<h1>Tabla de Estudiantes</h1>" +
                    "<table class='table'>" +
                    "<thead>" +
                        "<tr>" +
                            "<th scope='col'>ID</th>" +
                            "<th scope='col'>Nombre</th>" +
                            "<th scope='col'>Apellido</th>" +
                            "<th scope='col'>Materias</th>" +
                            "<th scope='col'>Carrera</th>" +
                            "<th scope='col'>Promedio</th>" +
                        "</tr>" +
                    "</thead>" +
                    "<tbody>";
    }

    public void AddBody(String html) {
        this.Body += html;
    }

    public void Export(String FileName) {
        try {
            // Crear archivo HTML
            File archivo = new File("src/frame/" + FileName + ".html");
            archivo.createNewFile();

            // Escribir código HTML en archivo
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<html>" + this.Head + "<body><div class='container'>" + this.Body + "</tbody></div></body>" + "<html>");
            bw.close();

            // Abrir el archivo HTML en el navegador predeterminado
            Desktop.getDesktop().browse(archivo.toURI());
        } catch (IOException e) {
            System.out.println("Error al Exportar resultado: " + e);
        }
    }
}