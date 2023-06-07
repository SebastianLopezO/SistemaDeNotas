public class Estudiante {
    private String Id, Nombre, Apellido, Carrera;
    private Estudiante Liga;
    private ColaMaterias Materias;

    public Estudiante(String Id, String Nombre, String Apellido, String Carrera) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Liga = null;
        this.Materias = null;
    }

    public Estudiante(String Id, String Nombre, String Apellido, String Carrera, Estudiante Liga) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Carrera = Carrera;
        this.Liga = Liga;
        this.Materias = null;
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

    public ColaMaterias getMaterias() {
        return Materias;
    }

    public void setMaterias(ColaMaterias materias) {
        Materias = materias;
    }
}