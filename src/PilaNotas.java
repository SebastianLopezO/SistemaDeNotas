public class PilaNotas {
    private int Tope,Lim;
    private int[] vec;

    public PilaNotas(){
        this.vec=new int[4];
        Tope=-1;
        Lim=3;
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
