import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ListaEstudiantes Lista = new ListaEstudiantes("PJIC");
        boolean app = true;
        while (app) {
            String Option = Menu();
            switch (Option) {
                case "Insertar Estudiante":
                    String Id=Integer.toString(GetId("Id"));
                    if(!Lista.Include(Id)){
                        Lista.Insert(Id,GetDato("Nombre"),GetDato("Apellido"),GetDato("Carrera"));
                    }else{
                        System.out.println("Este usuario ya existe");
                    }
                    break;
                case "Buscar Estudiante":
                    String doc = Integer.toString(GetId(Option));
                    Estudiante X = Lista.Buscar(doc);
                    boolean est = true;
                    if (X == null) {
                        System.out.println("Este estudiante con cedula " + doc + " no existe");
                        est = false;
                    }
                    while (est) {
                        String OptionEst = MenuEst(X.getNombre() + " " + X.getApellido(), X.getId());
                        switch (OptionEst) {
                            case "Agregar Materia":
                                X.Insert(GetDato());
                                break;
                            case "Buscar Materia":
                                 boolean Mat=true;
                                 String materia = GetDato("Materia");
                                 Materia M = X.Buscar(materia);

                                 if(M==null){
                                     System.out.println("La materia "+materia+" no existe");
                                     Mat=false;
                                 }
                                 while (Mat){
                                     String OptionMat = MenuMateria(X.getNombre()+X.getApellido(),X.getId(),materia);
                                     switch (OptionMat){
                                         case "Buscar Nota":
                                             break;
                                         case "Vaciar Notas":
                                             M.Empty();
                                             break;
                                         case "Modificar Materia":
                                             M.Modificar();
                                             break;
                                         case "Eliminar Materia":
                                             M.Eliminar();
                                             break;
                                         case "Volver":
                                             Mat=false;
                                             break;
                                     }
                                 }
                                break;
                            case "Vaciar Materias":
                                X.Empty();
                                break;
                            case "Modificar Estudiante":
                                X.Modificar();
                                break;
                            case "Eliminar Estudiante":
                                X.Eliminar();
                                break;
                            case "Volver":
                                est=false;
                                break;
                        }
                    }
                    break;
                case "Vaciar Lista":
                    Lista.Empty();
                    break;
                case "Salir":
                    app = false;
                    break;
            }
        }
        Lista.Insert("01", "Sebastian", "Lopez", "Ing Informatica");
        (Lista.getPunta()).Insert("Matematicas");
        ((Lista.getPunta()).getPunta()).Apilar(5);
        ((Lista.getPunta()).getPunta()).Apilar(4);
        ((Lista.getPunta()).getPunta()).Apilar(3);
        ((Lista.getPunta()).getPunta()).Apilar(2);
        (Lista.getPunta()).Insert("Calculo");
        ((Lista.getPunta()).getPunta().getLiga()).Apilar(2);
        ((Lista.getPunta()).getPunta().getLiga()).Apilar(2);
        ((Lista.getPunta()).getPunta().getLiga()).Apilar(2);
        ((Lista.getPunta()).getPunta().getLiga()).Apilar(2);


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

    public static String MenuEst(String Nombre, String ID) {
        String[] Options = {"Agregar Materia",
                "Buscar Materia",
                "Vaciar Materias",
                "Modificar Estudiante",
                "Eliminar Estudiante",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la accion para el Estudiante " + Nombre + "(" + ID + ") : ",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuMateria(String Nombre, String ID, String Materia) {
        String[] Options = {"Agregar Nota",
                "Buscar Nota",
                "Vaciar Notas",
                "Modificar Materia",
                "Eliminar Materia",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la accion para el Estudiante " + Nombre + "(" + ID + ") en la materia de " + Materia + " : ",
                "Opciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuNota(String Nombre, String ID, String Materia, int Nota) {
        String[] Options = {"Modificar Nota",
                "Eliminar Nota",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la accion para el Estudiante " + Nombre + "(" + ID + ") en la materia de " + Materia + " : ",
                "Opciones para la Nota " + Nota,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static int GetNum(String Option) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero a "+Option+ ": "));
                return num;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se ha insertado un numero.");
                System.out.println("No ha insertado un numero, error" + ex);
            }
        }
    }

    public static int GetId(String Option) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula a "+Option+ ": "));
                return num;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se ha insertado un numero.");
                System.out.println("No ha insertado un numero, error" + ex);
            }
        }
    }
}