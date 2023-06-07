public class Materia {
    private String Nombre;
    private int Tope,Lim;
    private int[] Vec;

    public Materia(String Nombre){
        this.Nombre=Nombre;
        this.Tope=-1;
        this.Lim=3;
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
        return Vec;
    }

    public void setVec(int[] vec) {
        this.Vec = vec;
    }

    public boolean PilaLlena(){
        if(this.Tope==this.Lim){
            return true;
        }
        return false;
    }

    public boolean PilaVacia(){
        if(this.Tope==-1){
            return true;
        }
        return false;
    }

    public int Desapilar(){
        int num=Vec[Tope];
        Tope--;
        return num;
    }

    public void Apilar(int nota){
        if(!PilaLlena()){
            Tope++;
            Vec[Tope]=nota;
        }
        System.out.println("Ya no se puede ingresar mas notas");
    }

    public void Modificar(String Materia){

    }

    public String ShowHtml(){
         String msj = "";
         Materia Aux= new Materia("");
        while(!PilaVacia()){
            int num=this.Desapilar();
            Aux.Apilar(num);
            msj+="<td>"+this.Desapilar()+"</td>";
        }
        this.Pasar(Aux);
        return msj;
    }

    public float Promedio(){
         Materia Aux=new Materia("");
         int sum=0;
        while(!PilaVacia()){
            int num=this.Desapilar();
            Aux.Apilar(num);
            sum+=num;
        }
        this.Pasar(Aux);
        return sum/4;
    }
}
