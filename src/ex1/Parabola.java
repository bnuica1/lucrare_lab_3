package ex1;

public class Parabola {
    public int a,b,c;
    public Parabola(int A,int B,int C)
    {
        this.a=A;
        this.b=B;
        this.c=C;
    }
    @Override
    public String toString()
    {
        return "f(x)= "+a+"x^2 + "+b+ "x + "+c;
    }
    public double[]Varf()
    {
        double varfx = -b/(2.0*a);
        double varfy= (-(b*b)+4.0*a*c)/4.0*a;
        return new double[] {varfx,varfy};
    }
    public  double[] Calculeaza_mijloc(Parabola p1)
    {
        double [] coord_1 = this.Varf();
        double [] coord_2=p1.Varf();
        double x_mid=(coord_1[0]+coord_2[0])/2.0;
        double y_mid=(coord_1[1]+coord_2[1])/2.0;
        return new double[] {x_mid,y_mid};
    }
    public static double[] Calculeaza_mijloc_static(Parabola p1,Parabola p2)
    {
        double [] coord_1 = p1.Varf();
        double [] coord_2=p2.Varf();
        double x_mid=(coord_1[0]+coord_2[0])/2.0;
        double y_mid=(coord_1[1]+coord_2[1])/2.0;
        return new double[] {x_mid,y_mid};
    }
    public double lungime_segment(Parabola p1)
    {
        double [] coord_1= this.Varf();
        double [] coord_2 = p1.Varf();
        double x1=coord_1[0];
        double y1=coord_1[1];
        double x2=coord_2[0];
        double y2=coord_2[1];
        return Math.hypot(x2-x1,y2-y1);
    }

    public static double lungime_segment_static(Parabola p1,Parabola p2)
    {
        double [] coord_1= p1.Varf();
        double [] coord_2 = p2.Varf();
        double x1=coord_1[0];
        double y1=coord_1[1];
        double x2=coord_2[0];
        double y2=coord_2[1];
        return Math.hypot(x2-x1,y2-y1);
    }
}
