package ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> parabole = new ArrayList<>();
        String nume_fis="in.txt";
        Scanner scanner = new Scanner(new File("in.txt"));
        while(scanner.hasNextInt())
        {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            Parabola p = new Parabola(a,b,c);
            parabole.add(p);
        }
        scanner.close();
        for(Parabola par : parabole)
        {
            System.out.println(par.toString());
            double [] varfurile = par.Varf();
            System.out.println("Varfurile sunt de coordonate: "+varfurile[0]  + ", "+varfurile[1]);
        }
        Parabola p1 = parabole.get(0);
        Parabola p2 = parabole.get(1);
        double [] coord_mijloc = p1.Calculeaza_mijloc(p2);
        System.out.println(coord_mijloc[0]+" "+ coord_mijloc[1]);
        System.out.println(p2.lungime_segment(p1));
        if (parabole.size()>=2)
        {
            double [] mijloc=Parabola.Calculeaza_mijloc_static(parabole.get(0),parabole.get(1));
            double lungime_de_segment=Parabola.lungime_segment_static(parabole.get(0),parabole.get(1));
            System.out.println("Coordonatele de mijloc sunt: " + mijloc[0]+","+ mijloc[1]);
            System.out.println("Lungimea de segment este: "+ lungime_de_segment);
        }

    }
}
