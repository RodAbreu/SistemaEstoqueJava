package Src;

public class Item {
    protected float Valor;
    protected String Nome;
    protected int Quantidade;
    protected int Indice;

    public Item(){}

    public void set_Valor(float Valor){this.Valor = Valor;}
    public void set_Nome(String Nome){this.Nome = Nome;}
    public void set_Quantidade(int Quantidade){this.Quantidade = Quantidade;}
    public void set_Indice(int Indice){this.Indice = Indice;}
    public float get_Valor(){return this.Valor;}
    public String get_Nome(){return this.Nome;}
    public int get_Quantidade(){return this.Quantidade;}
    public int get_Indice(){return this.Indice;}
}
