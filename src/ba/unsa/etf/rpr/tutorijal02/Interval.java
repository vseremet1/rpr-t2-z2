package ba.unsa.etf.rpr.tutorijal02;

public class Interval {


    double p, k;
    boolean p1, k1;


    public Interval(double pocetna, double krajnja, boolean pocetnaPripada, boolean krajnjaPripada) {
        p = pocetna;
        k = krajnja;
        p1 = pocetnaPripada;
        k1 = krajnjaPripada;

        if (k<p) throw new IllegalArgumentException();


    }


    public Interval() {
        p = 0;
        k = 0;
        p1 = false;
        k1 = false;
    }


    public boolean isNull() {

        if (this.p == 0 && this.k == 0 && this.p1 == false && this.k1 == false)
            return true;
        else return false;

    }

    public boolean isIn(double tacka) {
        if (tacka > p && tacka < k) return true;
        if (tacka == p && p1 == true) return true;
        if (tacka == k && k1 == true) return true;

        return false;
    }

    public Interval intersect(Interval i) {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;


        Interval i2 = new Interval();


        if (this.isIn(i.p)) a = true;
        if (this.isIn(i.k)) b = true;
        if (i.isIn(this.p)) c = true;
        if (i.isIn(this.k)) d = true;


        if (a) {
            i2.p = i.p;
            i2.p1 = i.p1;


        }

        if (d) {
            i2.k = this.k;

            i2.k1 = this.k1;
        }

        if (c) {
            i2.p = this.p;
            i2.p1 = this.p1;

        }

        if (b) {
            i2.k = i.k;

            i2.k1 = i.k1;
        }
        return i2;

    }

    public static Interval intersect(Interval i1, Interval i2) {
       return i1.intersect(i2);

    }

    public boolean equals(Interval i) {
        if (this.p == i.p && this.k == i.k && this.p1==i.p1 && this.k1==i.k1) return true;


        return false;
    }

    public String toString() {
        if (this.isNull()) return "()";

        if (this.k1==false && this.p1==true) return ("[" + this.p + "," + this.k + ")");
        if (this.p1==false && this.k1==false) return ("(" + this.p + "," + this.k + ")");
        if (this.p1==false)  return ("(" + this.p + "," + this.k + "]");


        return ("[" + this.p + "," + this.k + "]");



    }


}
