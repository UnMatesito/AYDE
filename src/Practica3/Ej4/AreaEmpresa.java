package Practica3.Ej4;

public class AreaEmpresa {
    private String iden;
    private int trans;

    public AreaEmpresa(String iden, int trans) {
        this.iden = iden;
        this.trans = trans;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public int getTrans() {
        return trans;
    }

    public void setTrans(int trans) {
        this.trans = trans;
    }
}
