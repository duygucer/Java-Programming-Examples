package IsYeri;


class Calisan {
    public String pozisyon="Calisan" ;
    public void calis() {}
}
class Mudur extends Calisan {

    public Mudur () { // yapılandırıcı
        pozisyon = "Mudur" ;
    }
    @Override
    public void calis() { // iptal etme (override)
        System.out.println("Mudur Calisiyor");
    }
}

class Programci extends Calisan {
    public Programci() { // yapılandırıcı
        pozisyon = "Programci" ;
    }
    @Override
    public void calis() { // iptal etme (override)
        System.out.println("Programci Calisiyor");
    }
}

class Pazarlamaci extends Calisan {
    public Pazarlamaci() { // yapılandırıcı
        pozisyon = "Pazarlamaci" ;
    }
    @Override
    public void calis() { // iptal etme (override)
        System.out.println("Pazarlamaci Calisiyor");
    }
}

public class IsYeri {
    public static void mesaiBasla(Calisan[] c ) {
        for (int i = 0 ; i < c.length ; i++) {
            c[i].calis(); // !Dikkat!
        }
    }
    public static void main(String args[]) {
        Calisan[] c = new Calisan[4];
        c[0] = new Calisan(); // yukarı cevirim gerekmiyor
        c[1] = new Programci(); // yukarı cevirim (upcasting)
        c[2] = new Pazarlamaci(); // yukarı cevirim (upcasting)
        c[3] = new Mudur(); // yukarı cevirim (upcasting)
        mesaiBasla(c);
    }
}
