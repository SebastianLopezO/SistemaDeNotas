public class Estudiante {
    private String Id, Nombre, Apellido, Carrera;
    private Estudiante Liga;
    private Materia Punta;

    public Estudiante(String Id, String Nombre, String Apellido, String Carrera) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Liga = null;
        this.Punta = null;
    }

    public Estudiante(String Id, String Nombre, String Apellido, String Carrera, Estudiante Liga) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Liga = Liga;
        this.Punta = null;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public Estudiante getLiga() {
        return Liga;
    }

    public void setLiga(Estudiante Liga) {
        this.Liga = Liga;
    }

    public Materia getPunta() {
        return Punta;
    }

    public void setPunta(Materia Punta) {
        this.Punta = Punta;
    }

    public void Insert(String Nombre){
        Materia X=new Materia(Nombre);
        this.EnColar(X);
    }

    public Materia DesenColar(){
        Materia aux=Punta;
        Punta=Punta.getLiga();
        return  aux;
    }
    public void EnColar(Materia X){
        if(Punta==null){
            Punta=X;
        }else{
            Materia P = this.Punta;
            while (P.getLiga() != null) {
                P = P.getLiga();
            }
            P.setLiga(X);
        }

    }

    public boolean ColaVacia(){
        if(Punta==null){
            return true;
        }
        return false;
    }

    public int Length(){
        Materia Init=Punta;
        int cont=0;
        if(Punta==null){
            return cont;
        }else{
            Materia aux=Punta;
            do{
                this.EnColar(this.DesenColar());
            }while (Punta!=Init);
            return cont;
        }

    }


    public int Promedio() {
        int lim=this.Length();
        int sum=0;
        for(int i=0;i<lim;i++){
            Materia Asignatura=this.DesenColar();
            sum+=Asignatura.Promedio();
            this.EnColar(Asignatura);

        }
        return sum/lim;
    }

    public String ShowHtml(){
        String msj = "<table class='table table-striped table-hover'>" +
                            "<thead>" +
                                    "<th>Nombre</th>" +
                                    "<th>Nota#1</th>" +
                                    "<th>Nota#2</th>" +
                                    "<th>Nota#3</th>" +
                                    "<th>Nota#4</th>" +
                                    "<th>Definitiva</th>" +
                            "</thead>" +
                            "<tbody>";
        int lim=this.Length();
        for(int i=0;i<lim;i++){
            Materia Asignatura=this.DesenColar();
            msj += "<tr>";
            msj += "<td>"+Asignatura.getNombre()+"</td>";
            msj += Asignatura.ShowHtml();
            msj += "<td>"+Asignatura.Promedio()+"</td>";
            msj += "</tr>";
            this.EnColar(Asignatura);
        }
        msj += "</tbody></table>";
        return msj;
    }

}
