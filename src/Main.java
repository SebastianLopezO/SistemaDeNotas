import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaEstudiantes Lista=new ListaEstudiantes("PJIC");

        Lista.ShowHtml();
    }

    public static String Menu() {
        String[] Options = {"Insertar Estudiante",
                "Buscar Estudiante",
                "Vaciar Lista",
                "Salir"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la accion para la lista: ",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuEst(String Nombre,String ID) {
        String[] Options = {"Agregar Materia",
                "Buscar Materia",
                "Vaciar Materias",
                "Modificar Estudiante",
                "Eliminar Estudiante",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la accion para el Estudiante "+Nombre+"("+ID+") : ",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuMateria(String Nombre,String ID, String Materia) {
        String[] Options = {"Agregar Nota",
                "Buscar Nota",
                "Vaciar Notas",
                "Modificar Materia",
                "Eliminar Materia",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la accion para el Estudiante "+Nombre+"("+ID+") en la materia de "+Materia+" : ",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuNota(String Nombre,String ID, String Materia,int Nota) {
        String[] Options = {"Modificar Nota",
                            "Eliminar Nota",
                            "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la accion para el Estudiante "+Nombre+"("+ID+") en la materia de "+Materia+" : ",
                "Opciones para la Nota "+Nota,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }
}