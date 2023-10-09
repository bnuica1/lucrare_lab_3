package ex2;

import java.time.LocalDate;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate data_expirarii;
    private static double incasari =0;
    public Produs(String Denumire,double Pret,int Cantitate,LocalDate DataExpirarii)
    {
        this.denumire=Denumire;
        this.pret=Pret;
        this.cantitate=Cantitate;
        this.data_expirarii=DataExpirarii;

    }
    public String getDenumire()
    {
        return this.denumire;
    }
    public double getPret()
    {
        return this.pret;
    }
    public int getCantitate()
    {
        return this.cantitate;
    }
    public LocalDate getDataExpirarii()
    {
        return this.data_expirarii;
    }
    public static double getIncasari()
    {
        return incasari;
    }
    public void vinzare (int cantitate_vanduta)
    {
        incasari+=cantitate_vanduta*pret;
        cantitate=cantitate-cantitate_vanduta;
        if(cantitate==0)
        {
            System.out.println("out of stock");
        }
        else
        {
            System.out.println("nu e suficienta cantitate");
        }
    }
    @Override
    public String toString()
    {
        return "Denumire: "+ denumire  + " " + "pret: "+ pret + " " +  "cantitate: "  + cantitate + " " + " Data expirarii: "+ data_expirarii;
    }

}
