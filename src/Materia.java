public class Materia {
    private String Nombre;
    private int Tope,Lim;
    private int[] vec;

    public Materia(String Nombre){
        this.Nombre=Nombre;
        this.Tope=-1;
        this.Lim=4;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getTope() {
        return Tope;
    }

    public void setTope(int tope) {
        Tope = tope;
    }

    public int getLim() {
        return Lim;
    }

    public void setLim(int lim) {
        Lim = lim;
    }

    public int[] getVec() {
        return vec;
    }

    public void setVec(int[] vec) {
        this.vec = vec;
    }

    public boolean ColaLlena(){
        if(this.Tope==this.Lim){
            return true;
        }
        return false;
    }

    public boolean ColaVacia()){
        if(this.Tope==-1){
            return true;
        }
        return false;
    }

    public void Insert(int nota){
        if(!ColaLlena()){
            Tope++;
            Vec[Tope]==nota;
        }
        System.out.println("Ya no se puede ingresar mas notas");
    }

    public void Modificar(String Materia){
        
    }
}
