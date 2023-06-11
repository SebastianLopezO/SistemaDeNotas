public class Estudiante {
    private String Nombre, Apellido, Carrera;
    private int Id;
    private Estudiante Liga;
    private Materia Punta,Tope;

    public Estudiante(int Id, String Nombre, String Apellido, String Carrera) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Liga = null;
        this.Punta = null;
        this.Tope = null;
    }

    public Estudiante(int Id, String Nombre, String Apellido, String Carrera, Estudiante Liga) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Liga = Liga;
        this.Punta = null;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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

    public void Insert(String Nombre,String Codigo){
        Materia X=new Materia(Nombre,Codigo);
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
            Tope=X;
        }else{
            Tope.setLiga(X);
            Tope=X;
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
                cont++;
                this.EnColar(this.DesenColar());
            }while (Punta!=Init);
            return cont;
        }

    }


    public float Promedio() {
        int lim=this.Length();
        float sum=0;
        for(int i=0;i<lim;i++){
            Materia Asignatura=this.DesenColar();
            sum+=Asignatura.Promedio();
            this.EnColar(Asignatura);

        }
        if(lim==0){
            return 0;
        }
        return sum/lim;
    }

    public String ShowHtml(){
        String msj = "<table class='table table-striped table-hover'>" +
                            "<thead>" +
                                    "<th>Nombre</th>" +
                                    "<th>Codigo</th>" +
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
            msj += "<td>"+Asignatura.getCodigo()+"</td>";
            msj += Asignatura.ShowHtml();
            msj += "<td>"+Asignatura.Promedio()+"</td>";
            msj += "</tr>";
            this.EnColar(Asignatura);
        }
        msj += "</tbody></table>";
        return msj;
    }

    public boolean Include(String materia) {
         Materia M = Punta;
        boolean exist = false;
        while (M != null) {
            if (M.getNombre() == materia) {
                exist = true;
            }
        }
        return exist;
    }
    public Materia Buscar(String materia) {
        if(this.Include(materia)){
            Materia M = Punta;
            while (M != null) {
                if (M.getNombre() == materia) {
                    return M;
                }
            }
        }
        return null;
    }

    public void Empty() {
        this.Punta=null;
        this.Tope=null;
    }

    public void Modificar(String[] mofE) {
        this.Nombre=mofE[0];
        this.Apellido=mofE[1];
        this.Carrera=mofE[2];
    }

}
