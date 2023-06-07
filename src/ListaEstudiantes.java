public class ListaEstudiantes {
    private Estudiante Punta;
    public String Uni;

    public ListaEstudiantes(String Uni) {
        this.Punta = null;
        this.Uni = Uni;
    }

    public Estudiante getPunta() {
        return Punta;
    }

    public void setPunta(Estudiante punta) {
        Punta = punta;
    }

    public String getUni() {
        return Uni;
    }

    public void setUni(String uni) {
        Uni = uni;
    }

    public void Insert(String Id, String Nombre, String Apellido, String Carrera) {
        Estudiante P, X = new Estudiante(Id, Nombre, Apellido, Carrera);
        if (Punta == null) {
            Punta = X;
        } else {
            P = this.Punta;
            while (P.getLiga() != null) {
                P = P.getLiga();
            }
            P.setLiga(X);
        }
    }

    public void BuscarRecursivo(String Id) {
        Estudiante P=Punta;
    }

    public void Empty() {
        this.Punta = null;
    }

    public int Length() {
        int cont = 0;
        Estudiante P = Punta;
        while (P != null) {
            P = P.getLiga();
            cont++;
        }
        return cont;
    }

    public void Show() {
        String msj = Uni +":"+ Clr.BG_BL+"[ "+Clr.BG_G+Punta+Clr.BG_BL;
        Estudiante P;
        for (P = this.Punta; P != null; P = P.getLiga()) {
            msj += " { " +P.getId() +  " | " + " " + P.getNombre() + " | " +  P.getApellido() +" }  => \n\t\t"+Clr.BG_G+P.getLiga()+Clr.BG_BL;
        }
        msj += "\n]"+Clr.RT;
        System.out.println(msj);
    }

    public void ShowHtml(){
        String msj = "<tr>";
        Estudiante P;
        for (P = this.Punta; P != null; P = P.getLiga()) {
            msj += "<th scope='row'>"+P.getId()+"</th>";
            msj += "<td>"+P.getNombre()+"</td>";
            msj += "<td>"+P.getApellido()+"</td>";
            msj += "<td>"+P.Mostrar()+"</td>";
            msj += "<td>"+P.getCarrera()+"</td>";
            msj += "<td>"+P.Promedio()+"</td>";
        }
        msj += "</tr>";
        System.out.println(msj);
    }
}
