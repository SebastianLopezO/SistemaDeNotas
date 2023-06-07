public class ListaEstudiantes {
    private Estudiante Punta;
    public String Uni;

    public ListaEstudiantes(String Uni){
        this.Punta=null;
        this.Uni=Uni;
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

    public void Insertar(String Id,String Nombre,String Apellido,String Carrera){
        Estudiante est=new Estudiante(Id,Nombre,Apellido,Carrera);
        if(Punta==null){
            Punta=est;
        }else{
            Estudiante P=Punta;
            while (P.getLiga()!=null){
                P=P.getLiga();
            }
            P.setLiga(est);
        }
    }

    public void Mostrar() {
        String msj = Clr.BG_BL + "\n" + this.Uni + ": [ ";
        Estudiante P = this.Punta;
        while (P!=null){
            msj += "{ | " + Clr.BG_Y + " " + P.getNombre() + " " + Clr.BG_BL + " | " + Clr.BG_G + P.getLiga() + Clr.BG_BL + " }  => ";
            P = P.getLiga();
        }
        msj += " ]\n\n" + Clr.RT;
        System.out.println(msj);
    }
}
