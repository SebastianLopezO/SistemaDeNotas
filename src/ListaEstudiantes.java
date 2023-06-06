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
}
