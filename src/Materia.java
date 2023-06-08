public class Materia {
    private String Nombre,Codigo;

    private Materia Liga;
    private int Tope,Lim;
    private float[] Vec;

    public Materia(String Nombre,String Codigo){
        this.Nombre=Nombre;
        this.Codigo=Codigo;
        this.Tope=-1;
        this.Lim=3;
        this.Liga=null;
        this.Vec=new float[4];
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

    public float[] getVec() {
        return Vec;
    }

    public void setVec(float[] vec) {
        this.Vec = vec;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public Materia getLiga() {
        return Liga;
    }

    public void setLiga(Materia liga) {
        Liga = liga;
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

    public float Desapilar(){
        float num=Vec[Tope];
        Tope--;
        return num;
    }

    public void Apilar(float nota){
        if(!PilaLlena()){
            Tope++;
            Vec[Tope]=nota;
        }else {
            System.out.println("Ya no se puede ingresar mas notas");
        }
    }

    public void Modificar(String Materia){

    }

    public void Pasar(Materia Aux){
        while (!Aux.PilaVacia()){
            float num=Aux.Desapilar();
            this.Apilar(num);
        }
    }
    public String ShowHtml(){
         String msj = "";
         Materia Aux= new Materia("","");
        while(!PilaVacia()){
            float num=this.Desapilar();
            Aux.Apilar(num);
            msj+="<td>"+num+"</td>";
        }
        this.Pasar(Aux);
        return msj;
    }

    public float Promedio(){
         Materia Aux=new Materia("","");
         int sum=0;
        while(!PilaVacia()){
            float num=this.Desapilar();
            Aux.Apilar(num);
            sum+=num;
        }
        this.Pasar(Aux);
        return sum/4;
    }

    public void Empty() {
        this.Tope=-1;
    }
}
