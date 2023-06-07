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
}
