package ex2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws IOException {
        List<Produs> produse =new ArrayList<>();
        Scanner scanner = new Scanner(new File("produse.txt"));
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] elemente = line.split(",");
            String denumire=elemente[0].trim();
            double pret =Double.parseDouble(elemente[1].trim());
            int cantitate= Integer.parseInt(elemente[2].trim());
            LocalDate Data_exp=LocalDate.parse(elemente[3].trim());
            Produs prod = new Produs(denumire,pret,cantitate,Data_exp);
            produse.add(prod);
        }
        scanner.close();
        Scanner input = new Scanner(System.in);
        afisare_produs(produse);
        afisare_produs_expirat(produse);
        vinde_produs(produse,input);
        pret_minim(produse);
        salvare_in_fisier(produse,input);



    }
    public static void afisare_produs(List<Produs> produse)
    {
        for(Produs produs:produse)
        {
            System.out.println(produs);
        }
    }
    public static void afisare_produs_expirat(List<Produs> produse)
    {
        LocalDate currentdate = LocalDate.now();
        for(Produs produs:produse)
        {
            if(produs.getDataExpirarii().isBefore(currentdate))
            System.out.println(produs);
        }
    }
    public static void vinde_produs(List<Produs> produse,Scanner input) {
        System.out.println("Introd Denumire prod: ");
        String denumire = input.nextLine();
        System.out.println("Introd Cantitat vanduta: ");
        int cantitate_vanduta = input.nextInt();
        for (Produs produs : produse) {
            if (produs.getCantitate() < 0) {
                produse.remove(produs);
            }
            if (produs.getDenumire().equalsIgnoreCase(denumire)) {

                    produs.vinzare(cantitate_vanduta);
                    return;
                }
            }
        }
    public static void pret_minim(List<Produs> produse) {

        double minim=500000;
        for (Produs produs : produse)
        {
            if(produs.getPret()<=minim)
            {
                minim= produs.getPret();
            }
        }

        for (Produs produs : produse)
        {
            if(produs.getPret()==minim)
            {
                System.out.println(produs.toString());
            }
        }
    }
    public static void salvare_in_fisier(List<Produs> produse, Scanner input) throws IOException {
        System.out.println("pret: ");
        int cantitate=input.nextInt();
        BufferedWriter flux_out;
        flux_out=new BufferedWriter(new FileWriter("iesire.txt"));
        for (Produs produs : produse)
        {
            if(produs.getCantitate()<cantitate)
                flux_out.write(produs.toString());
        }
        flux_out.close();

    }

}
