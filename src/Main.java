import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ListaEstudiantes Lista = new ListaEstudiantes("PJIC");
        boolean app = true;
        while (app) {
            String Option = Menu();
            switch (Option) {
                case "Insertar Estudiante":
                    String Id = Integer.toString(GetNum("Cedula", Option));
                    if (!Lista.Include(Id)) {
                        Lista.Insert(Id, GetDato("Nombre", Option), GetDato("Apellido", Option), GetDato("Carrera", Option));
                    } else {
                        System.out.println("Este usuario ya existe");
                    }
                    break;
                case "Buscar Estudiante":
                    String doc = Integer.toString(GetNum("Cedula", Option));
                    Estudiante X = Lista.Buscar(doc);
                    boolean est = true;
                    if (X == null) {
                        System.out.println("Este estudiante con cedula " + doc + " no existe");
                        est = false;
                    }
                    while (est) {
                        String OptionEst = MenuEst(X.getNombre() + " " + X.getApellido(), X.getId());
                        String materia;
                        String codigo;
                        switch (OptionEst) {
                            case "Agregar Materia":
                                materia=GetDato("materia", OptionEst);
                                codigo=GetDato("materia", OptionEst);
                                if(!X.Include(materia)){
                                    X.Insert(materia,codigo);
                                }else {
                                    System.out.println("Esta materia ya existe");
                                }
                                break;
                            case "Buscar Materia":
                                boolean Mat = true;
                                materia = GetDato("materia", OptionEst);
                                Materia M = X.Buscar(materia);

                                if (M == null) {
                                    System.out.println("La materia " + materia + " no existe");
                                    Mat = false;
                                }
                                while (Mat) {
                                    String OptionMat = MenuMateria(X.getNombre() + X.getApellido(), X.getId(), materia);
                                    switch (OptionMat) {
                                        case "Buscar Nota":
                                            break;
                                        case "Vaciar Notas":
                                            M.Empty();
                                            break;
                                        case "Modificar Materia":
                                            String[] mofM=MenuModificar(new String[]{"Nombre Materia","Codigo Materia"},new String[]{});
                                            break;
                                        case "Eliminar Materia":
                                            //M.Eliminar();
                                            break;
                                        case "Volver":
                                            Mat = false;
                                            break;
                                    }
                                }
                                break;
                            case "Vaciar Materias":
                                X.Empty();
                                break;
                            case "Modificar Estudiante":
                                String[] mofE=MenuModificar(new String[]{"Nombre","Apellido","Carrera"},new String[]{X.getNombre(),X.getApellido(),X.getCarrera()});
                                X.Modificar(mofE);
                                break;
                            case "Eliminar Estudiante":
                                X.Eliminar();
                                break;
                            case "Volver":
                                est = false;
                                break;
                        }
                    }
                    break;
                case "Vaciar Lista":
                    Lista.Empty();
                    break;
                case "Mostrar Lista":
                    Lista.ShowHtml();
                case "Salir":
                    app = false;
                    break;
            }
        }
        Lista.Insert("01", "Sebastian", "Lopez", "Ing Informatica");
        (Lista.getPunta()).Insert("Matematicas","CBS12939");
        ((Lista.getPunta()).getPunta()).Apilar(5);
        ((Lista.getPunta()).getPunta()).Apilar(4);
        ((Lista.getPunta()).getPunta()).Apilar(3);
        ((Lista.getPunta()).getPunta()).Apilar(2);
        (Lista.getPunta()).Insert("Calculo","CBS12939");
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
                "Mostrar Lista",
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

    public static String[] MenuModificar(String[] Scheme,String[] Values) {
        String[] out=new String[Scheme.length];
        for(int i=0;i<Scheme.length;i++){
            String input = (String) JOptionPane.showInputDialog(null, "Ingrese el/la "+Scheme[i],Values[i]);
            out[i]=input;
        }
        return  out;

    }

    public static int GetNum(String type, String Option) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero de " + type + " para " + Option + ": "));
                return num;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "No se ha insertado un numero.");
                System.out.println("No ha insertado un numero, error" + ex);
            }
        }
    }

    private static String GetDato(String type, String Option) {
        String line;
        while (true) {
            line = JOptionPane.showInputDialog("Ingrese el/la " + type + " para " + Option + ": ");
            if (line.trim().isEmpty()) {
                System.out.println("No puedes asignar Un/a " + type + " vacio o con numeros");
            } else {
                return line;
            }
        }
    }

}