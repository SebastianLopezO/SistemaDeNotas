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

    public void Insert(int Id, String Nombre, String Apellido, String Carrera) {
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
        Estudiante P = Punta;
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

    public boolean Include(int id) {
        Estudiante E = Punta;
        boolean exist = false;
        while (E != null) {
            if (E.getId() == id) {
                exist = true;
                System.out.println("la cedula "+E.getId()+" es igual a "+id);
            }
            System.out.println("la cedula "+E.getId()+" no es igual a "+id);
            E = E.getLiga();
        }
        return exist;
    }

    public Estudiante Buscar(int doc) {
        if (this.Include(doc)) {
            Estudiante E = Punta;
            while (E != null) {
                if (E.getId() == doc) {
                    return E;
                }
                E = E.getLiga();
            }
        }
        return null;

    }

    public void Show() {
        String msj = Uni + ":" + Clr.BG_BL + "[ " + Clr.BG_G + Punta + Clr.BG_BL;
        Estudiante P;
        for (P = this.Punta; P != null; P = P.getLiga()) {
            msj += " { " + P.getId() + " | " + " " + P.getNombre() + " | " + P.getApellido() + " }  => \n\t\t" + Clr.BG_G + P.getLiga() + Clr.BG_BL;
        }
        msj += "\n]" + Clr.RT;
        System.out.println(msj);
    }

    public void ShowHtml() {
        String msj = "";
        Estudiante Est;
        for (Est = this.Punta; Est != null; Est = Est.getLiga()) {
            msj += "<tr>";
            msj += "<th scope='row'>" + Est.getId() + "</th>";
            msj += "<td>" + Est.getNombre() + "</td>";
            msj += "<td>" + Est.getApellido() + "</td>";
            msj += "<td>" + Est.ShowHtml() + "</td>";
            msj += "<td>" + Est.getCarrera() + "</td>";
            msj += "<td>" + Est.Promedio() + "</td>";
            msj += "</tr>";
        }
        Html File = new Html();
        File.AddBody(msj);
        File.Export(Uni);
    }

    public void Eliminar(Estudiante X) {
        if (Punta == X) {
            Punta = Punta.getLiga();
        } else if (Punta != null) {
            Estudiante P = Punta;
            while (P.getLiga() != X) {
                P = P.getLiga();
            }
            P.setLiga(X.getLiga());
        } else {
            System.out.println("La lista esta vacia");
        }
    }
}
