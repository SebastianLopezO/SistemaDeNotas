import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaEstudiantes Lista=new ListaEstudiantes("PJIC");
        Lista.Insert("01","Sebastian","Lopez","Ing Informatica");
        (Lista.getPunta()).Insert("Ingles");
        Lista.Show();
    }
}