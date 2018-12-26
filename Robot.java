package prolab;

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

interface Robot {

    public int motorSayisi = 0;
    public double yukMiktari = 0;
    public String robotTipi = "";

    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi);
}

interface Gezgin extends Robot {

    int gezinmeHizi = 0;

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi);
}

interface Manipulator extends Robot {

    double yukTasimaKapasitesi = 0;
    double KolUzunlugu = 0;
    double tasimaHizi = 0;

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi);
}

class Spider implements Gezgin {

    int bacakSayisi;
    int gezinmeHizi;

    Spider(int motorSayisi, double yukMiktari, String robotTipi, int gezinmeHiz, int bacakSayisi) {
        this.bacakSayisi = bacakSayisi;
        this.gezinmeHizi = gezinmeHiz;
    }

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi) {
        System.out.println("Motor Sayisi : " + motorSayisi);
        System.out.println("Yuk Miktarı : " + yukMiktari);
        System.out.println("Robot Tipi : " + robotTipi);
        System.out.println("Gezinme Hızı : " + gezinmeHizi);
        System.out.println("Bacak Sayisi : " + bacakSayisi);
    }

}

class Paletli implements Gezgin {

    int paletSayisi;
    int gezinmeHizi;

    public Paletli(int motorSayisi, double yukMiktari, String robotTipi, int gezinmeHiz, int paletSayisi) {
        this.paletSayisi = paletSayisi;
        this.gezinmeHizi = gezinmeHiz;
    }

    public double EngelGecmeSuresiBul(int motorS) {
        double engelG;
        engelG = motorS * 3;
        return engelG;
    }

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi) {
        System.out.println("Motor Sayisi : " + motorSayisi);
        System.out.println("Yuk Miktarı : " + yukMiktari);
        System.out.println("Robot Tipi : " + robotTipi);
        System.out.println("Gezinme Hızı : " + gezinmeHizi);
        System.out.println("Palet Sayisi : " + paletSayisi);
    }

}

class Tekerlekli implements Gezgin {

    int tekerlekSayisi;
    int gezinmeHizi;

    Tekerlekli(int tekerlekSayisi, int motorSayisi, double yukMiktari, String robotTipi, int gezinmeHiz) {
        this.tekerlekSayisi = tekerlekSayisi;
        this.gezinmeHizi = gezinmeHiz;
    }

    public double EngelGecmeSuresiBul(int motorS) {
        double engelG;
        engelG = (motorS * 0.5);
        return engelG;
    }

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi) {
        System.out.println("Motor Sayisi : " + motorSayisi);
        System.out.println("Yuk Miktarı : " + yukMiktari);
        System.out.println("Robot Tipi : " + robotTipi);
        System.out.println("Gezinme Hızı : " + gezinmeHizi);
        System.out.println("Tekerlek Sayisi : " + tekerlekSayisi);
    }
}

class Seri implements Manipulator {

    double yukTasimaKapasitesi;
    double KolUzunlugu;
    double tasimaHizi;

    Seri(double yukTasimaKapasite, double KolUzun, double tasimaHiz, int motorSayisi, double yukMiktari, String robotTipi) {
        this.yukTasimaKapasitesi = yukTasimaKapasite;
        this.KolUzunlugu = KolUzun;
        this.tasimaHizi = tasimaHiz;
    }

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi) {
        System.out.println("Motor Sayisi : " + motorSayisi);
        System.out.println("Yuk Miktarı : " + yukMiktari);
        System.out.println("Robot Tipi : " + robotTipi);
        System.out.println("Yuk Tasima Kapasitesi: " + yukTasimaKapasitesi);
        System.out.println("KolUzunlugu: " + KolUzunlugu);
        System.out.println("Tasima Hizi: " + tasimaHizi);
    }
}

class Paralel implements Manipulator {

    double yukTasimaKapasitesi;
    double KolUzunlugu;
    double tasimaHizi;

    public Paralel(double yukTasimaKapasite, double KolUzun, double tasimaHiz, int motorSayisi, double yukMiktari, String robotTipi) {
        this.yukTasimaKapasitesi = yukTasimaKapasite;
        this.KolUzunlugu = KolUzun;
        this.tasimaHizi = tasimaHiz;
    }

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi) {
        System.out.println("Motor Sayisi : " + motorSayisi);
        System.out.println("Yuk Miktarı : " + yukMiktari);
        System.out.println("Robot Tipi : " + robotTipi);
        System.out.println("Yuk Tasima Kapasitesi: " + yukTasimaKapasitesi);
        System.out.println("KolUzunlugu: " + KolUzunlugu);
        System.out.println("Tasima Hizi: " + tasimaHizi);
    }

}

class Hibrit implements Gezgin, Manipulator {

    int tekerlekSayisi;
    int bacakSayisi;
    int paletSayisi;
    int gezinmehizi;
    double koluzunlugu;
    double tasimahizi;
    int sabitlenmeSuresi;
    int gecisSuresi;

    public Hibrit(double yukTasimaKapasite, double KolUzun, double tasimaHiz, int GezinmeH, int bacakSayi, int PaletSayisi, int tekerleksayisi, int motorSayisi, double yukMiktari, String robotTipi, int sabitlenmeSuresi, int gecisSuresi) {
        this.bacakSayisi = bacakSayi;
        this.gezinmehizi = GezinmeH;
        this.koluzunlugu = KolUzun;
        this.paletSayisi = PaletSayisi;
        this.tasimahizi = tasimaHiz;
        this.tekerlekSayisi = tekerleksayisi;
        this.sabitlenmeSuresi = sabitlenmeSuresi;
        this.gecisSuresi = gecisSuresi;
    }

    @Override
    public void bilgileriGoster(int motorSayisi, double yukMiktari, String robotTipi) {
        System.out.println("Motor Sayisi : " + motorSayisi);
        System.out.println("Yuk Miktarı : " + yukMiktari);
        System.out.println("Robot Tipi : " + robotTipi);
        System.out.println("Gezinme Hizi: " + gezinmehizi);
        System.out.println("Bacak Sayisi: " + bacakSayisi);
        System.out.println("Tekerlek Sayisi: " + tekerlekSayisi);
        System.out.println("Palet Sayisi: " + paletSayisi);
        System.out.println("Kol Uzunluğu: " + koluzunlugu);
        System.out.println("Taşıma Hızı: " + tasimahizi);
        System.out.println("Sabitlenme Suresi : " + sabitlenmeSuresi);
        System.out.println("Gecis Suresi : " + gecisSuresi);
    }

    public double EngelGecmeSuresiBul(int motorS, String robotT) {
        if (robotT.equalsIgnoreCase("paletli")) {
            double engelG;
            engelG = motorS * 3;
            return engelG;
        } else if (robotT.equalsIgnoreCase("tekerlekli")) {
            double engelG;
            engelG = (motorS * 0.5);
            return engelG;
        }
        return 0;
    }
}

class GraphicsDemo extends Applet {

    JPanel panel1;
    int RSayisi;
    String[] diziRs = new String[RSayisi];
    double[] kolUzunluklari = new double[RSayisi];
    int[] sabitlenmeSureleri = new int[RSayisi];
    int[] gecikmeSureleri = new int[RSayisi];
    int[] gezinmeHizlari = new int[RSayisi];
    double[] tasimaHizlari = new double[RSayisi];
    double[] engeldenGecmeSureleri = new double[RSayisi];

    public GraphicsDemo(int Rsayisi, String[] diziRS, double[] KolUzunluklari, int[] gezinmeHizlari, double[] tasimaHizlari, int[] sabitlenmeSureleri, int[] gecikmeSureleri, double[] engeldenGecmeSureleri) {
        panel1 = new JPanel();
        this.RSayisi = Rsayisi;
        this.diziRs = diziRS;
        this.kolUzunluklari = KolUzunluklari;
        this.gezinmeHizlari = gezinmeHizlari;
        this.tasimaHizlari = tasimaHizlari;
        this.sabitlenmeSureleri = sabitlenmeSureleri;
        this.gecikmeSureleri = gecikmeSureleri;
        this.engeldenGecmeSureleri = engeldenGecmeSureleri;
    }

    @Override
    public void paint(Graphics g) {
        int i, j;
        int n = 1;//robot sayısına bağlı olarak grafikleri temizlemek için
        //Cerceve
        g.setColor(Color.RED);
        g.drawLine(50, 50, 50, 850);
        g.drawLine(51, 51, 51, 851);
        g.drawLine(50, 50, 850, 50);
        g.drawLine(51, 51, 851, 51);
        g.drawLine(50, 850, 850, 850);
        g.drawLine(51, 851, 851, 851);
        g.drawLine(850, 50, 850, 850);
        g.drawLine(851, 51, 851, 851);

        //Satirlar
        g.setColor(Color.BLACK);
        for (i = 40; i <= 760; i += 40) {
            g.drawLine(50, 50 + i, 850, 50 + i);
        }
        //Sutunlar
        for (i = 40; i <= 760; i += 40) {
            g.drawLine(50 + i, 50, 50 + i, 850);

        }
        Scanner input = new Scanner(System.in);
////////////////////////////////////////////////////////engelciz fonk//////////////////
        for (i = 0; i < RSayisi; i++) {
            System.out.println("Hangi sıradaki robot hareket ettirilecek?");
            for (j = 1; j <= RSayisi; j++) {
                System.out.println((j) + " - " + diziRs[j - 1]);
            }
            System.out.print("Seciminiz: ");
            int secim = input.nextInt();

            System.out.println(secim + " . sıradaki robot secildi. " + secim + " .robot türü: " + diziRs[secim - 1]);
            input.nextLine();
            System.out.println("Izgaraya engel yerleştirmek ister misiniz? [Evet/Hayır] \n");
            String komut = input.nextLine();
            int engelS = 0;
            int[] engellerx = new int[20];
            int[] engellery = new int[20];
            if (komut.equalsIgnoreCase("Evet")) {
                System.out.println("Kaç adet engel yerleştirmek istersiniz?\n");
                engelS = input.nextInt();
                for (j = 0; j < engelS; j++) {
                    System.out.println((j + 1) + " .engeli yerleştirmek istediginiz lokasyonu x ve y ekseninde giriniz:\n");
                    engellerx[j] = input.nextInt();
                    engellery[j] = input.nextInt();
                    if (engellerx[j] > 0 && engellerx[j] < 21 && engellery[j] > 0 && engellery[j] < 21) {
                        engellerx[j] = engellerx[j] * 40;
                        engellery[j] = engellery[j] * 40;
                        g.setColor(Color.BLACK);
                        g.fillRect(17 + engellerx[j], 17 + engellery[j], 26, 26);
                    }
                }
            } else {
                System.out.println("Engel yerleştirilmedi... ");

            }
            for(i=0;i<engelS;i++)
            System.out.println("Engellerin konumları: "+engellerx[i]+" "+engellery[i]);
////////////////////////////////////////////////////robotcizfonk////////////////////////

            System.out.println(diziRs[secim - 1] + " robotunun konumunu sırasıyla x ve y eksenleri olarak giriniz: ");
            int konumx = input.nextInt();
            int konumy = input.nextInt();
            int yenikonumx = konumx * 40;
            int yenikonumy = konumy * 40;
            System.out.println(diziRs[secim - 1] + " robotu ızgaraya yerleştiriliyor... \n");
            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
            input.nextLine();
            System.out.println("Robot yükü yüklendi...");
            g.setColor(Color.BLACK);
            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
            g.setColor(Color.RED);
            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
            //manipülatorun hareket etmemesini kontrol ediyoruz.
            int alinanyol = 0;
            int atlananengels = 0;
            if (!diziRs[secim - 1].equalsIgnoreCase("seri") && !diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                System.out.println(diziRs[secim - 1] + " robotu icin hareket yonlerini giriniz. \n");
                System.out.println("Robotun hareket etmeyeceği yönler için 0 giriniz. \n");
                System.out.println("İleri: ");
                int ileri = input.nextInt();
                if (ileri + konumy <= 20) {
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < ileri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i]== yenikonumx && engellery[i]== yenikonumy+j) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((engellery[i]-40-yenikonumy)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i];
                                    yenikonumy = engellery[i]-40;
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }
                            }
                        }
                    }

                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < ileri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i]== yenikonumx && engellery[i]== yenikonumy+j) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    System.out.println(diziRs[secim - 1] + " robot hareket ediyor...");
                    yenikonumy = yenikonumy + (ileri * 40);
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                    //g.clearRect(17+yenikonumx, 17+yenikonumy-40, 26, 26);
                    //}
                    System.out.println("Robot belirlenen konumda.");
                    konumy = konumy + ileri;
                    //yolda spider varsa olasılığını yaz
                }  
                else {
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < ileri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx && engellery[i] == yenikonumy+j) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((engellery[i]-40-yenikonumy)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i];
                                    yenikonumy = engellery[i]-40;
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }
                            }
                        }
                    }
                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < ileri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i]== yenikonumx && engellery[i] == yenikonumy+j) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                    System.out.println(diziRs[secim - 1] + " robot ızgaranın dışına çıktığı için program sonlandırıldı. \n");
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    yenikonumy = 20 * 40;
                    System.out.println(diziRs[secim - 1] + " robotun son bulunduğu konum gösteriliyor.. ");
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                    System.out.println("*********************************");
                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((20-konumy)*gezinmeHizlari[secim-1]*10)+(atlananengels*engeldenGecmeSureleri[secim-1]));
                    
                    break;
                }
                System.out.println("Sağa: ");
                int sag = input.nextInt();
                if (sag + konumx <= 20) {
                    
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sag*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i]== yenikonumx+j && engellery[i]== yenikonumy) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((engellerx[i]-40-yenikonumx+ileri)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i]-40;
                                    yenikonumy = engellery[i];
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }
                            }
                        }
                    }

                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sag*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i]== yenikonumx+j && engellery[i] == yenikonumy) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                 
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    System.out.println(diziRs[secim - 1] + " robot hareket ediyor...");
                    yenikonumx = yenikonumx + (sag * 40);
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                    System.out.println("Robot belirlenen konumda.");
                    konumx = konumx + sag;
                    
                }
                else {
                
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sag*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx+j && engellery[i] == yenikonumy) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((engellerx[i]-40-yenikonumx+ileri)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i]-40;
                                    yenikonumy = engellery[i];
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }
                            }
                        }
                    }
                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sag*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx+j && engellery[i] == yenikonumy) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                    System.out.println(diziRs[secim - 1] + " robot ızgaranın dışına çıktığı için program sonlandırıldı. \n");
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    yenikonumx = 20 * 40;
                    System.out.println(diziRs[secim - 1] + " robotun son bulunduğu konum gösteriliyor.. ");
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                    System.out.println("*********************************");
                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((ileri+20-konumx)*gezinmeHizlari[secim-1]*10)+(atlananengels*engeldenGecmeSureleri[secim-1]));
                    
                }
                System.out.println("Sola: ");
                int sol = input.nextInt();
                if (konumx - sol > 0) {
                    
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sol*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx-j && engellery[i] == yenikonumy) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((yenikonumx-engellerx[i]+40+ileri+sag)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i]+40;
                                    yenikonumy = engellery[i];
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }
                              
                            }
                            
                        }
                    }
                    
                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sol*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx-j && engellery[i] == yenikonumy) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    System.out.println(diziRs[secim - 1] + " robot hareket ediyor...");
                    yenikonumx = yenikonumx - (sol * 40);
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);

                    System.out.println("Robot belirlenen konumda.");
                    konumx = konumx - sol;
                    

                } else {
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sol*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx-j && engellery[i] == yenikonumy) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((yenikonumx-engellerx[i]+40+ileri+sag)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i]+40;
                                    yenikonumy = engellery[i];
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }     
                            }
                        }
                    }
                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < sol*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx-j && engellery[i] == yenikonumy) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                    System.out.println(diziRs[secim - 1] + " robot ızgaranın dışına çıktığı için program sonlandırıldı. \n");
                    System.out.println("*********************************");
                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((ileri+sag+(yenikonumx/40))*gezinmeHizlari[secim-1]*10)+(atlananengels*engeldenGecmeSureleri[secim-1]));
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    yenikonumx = 1 * 40;
                    System.out.println(diziRs[secim - 1] + " robotun son bulunduğu konum gösteriliyor.. ");
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                    
                    break;
                }
                System.out.println("Geri: ");
                int geri = input.nextInt();
                if (konumy - geri > 0) {
                    
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < geri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx && engellery[i] == yenikonumy-j) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((+ileri+sag+sol+yenikonumy-engellery[i]+40)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i];
                                    yenikonumy = engellery[i]+40;
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }
                               
                            }
                        }
                    }

                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < geri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx && engellery[i] == yenikonumy-j) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    System.out.println(diziRs[secim - 1] + " robot hareket ediyor...");
                    yenikonumy = yenikonumy - (geri * 40);
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                    System.out.println("Robot belirlenen konumda.");
                    
                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((ileri+geri+sag+sol)*gezinmeHizlari[secim-1]*10)+(atlananengels*engeldenGecmeSureleri[secim-1]));
                    konumy = konumy - geri;
                    
                } else {
                    if (diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j <geri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx && engellery[i] == yenikonumy-j) {
                                    System.out.println("Spider robot engelle karsilasti ve bu engeli asamiyor!");
                                    System.out.println("*********************************");
                                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((yenikonumy-engellery[i]+40)*gezinmeHizlari[secim-1]*10)/40+(atlananengels*engeldenGecmeSureleri[secim-1]));
                                    yenikonumx = engellerx[i];
                                    yenikonumy = engellery[i]+40;
                                    g.setColor(Color.BLACK);
                                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                                    g.setColor(Color.RED);
                                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                                    break;
                                }
                            }
                        }
                    }
                    if (!diziRs[secim - 1].contains("spider")) {
                        for (j = 0; j < geri*40; j+=40) {
                            for (i = 0; i < engelS; i++) {
                                if (engellerx[i] == yenikonumx && engellery[i] == yenikonumy-j) {
                                    atlananengels++;
                                }
                            }
                        }
                    }
                    System.out.println(diziRs[secim - 1] + " robot ızgaranın dışına çıktığı için program sonlandırıldı. \n");
                    g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    yenikonumy = 1 * 40;
                    System.out.println(diziRs[secim - 1] + " robotun son bulunduğu konum gösteriliyor.. ");
                    g.setColor(Color.BLACK);
                    g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                    g.setColor(Color.RED);
                    g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                    if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli") || diziRs[secim - 1].equalsIgnoreCase("spider") || diziRs[secim - 1].equalsIgnoreCase("paletli")) {
                    System.out.println("*********************************");
                    System.out.println(diziRs[secim - 1] + " robotunun hareket süresi: "+((ileri+sag+sol+konumy)*gezinmeHizlari[secim-1]*10)+(atlananengels*engeldenGecmeSureleri[secim-1]));
                    }
                    break;
                }
                input.nextLine();
                alinanyol = ileri + geri + sol + sag;
            }
            if(diziRs[secim-1].equalsIgnoreCase("seri")||diziRs[secim-1].equalsIgnoreCase("paralel"))
            gezinmeHizlari[secim-1]=1;

            double GezinmeSure = alinanyol / gezinmeHizlari[secim - 1];
            int kolciz = (int) (kolUzunluklari[secim - 1] / 10) * 40;
            int yukkonumx = 0;
            int yukkonumy = 0;

//Yükleri kollarıyla bir yerden bir yere taşıyan robotlar için
            if (diziRs[secim - 1].contains("seri") || diziRs[secim - 1].contains("paralel")) {

                g.setColor(Color.BLACK);
                g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                g.setColor(Color.RED);
                g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);

                System.out.println("Yükü taşımak istediğiniz konumun hareket yonlerini giriniz: ");
                System.out.println("Kolun hareket etmeyeceği yönler için 0 giriniz. \n");
                System.out.println("Girdiginiz kol uzunluğunuz birim cinsinden : " + (kolciz / 40));
                System.out.println("İleri: ");
                int kolx = yenikonumx;
                int koly = yenikonumy;
                int kollx = 0;
                int kolly = 0;
                double TasimaSure = 0;
                int ileri = input.nextInt();
                for (i = 0; i < 1; i++) {
                    if (ileri > (kolciz / 40)) {
                        if ((yenikonumy / 40) + (kolciz / 40) > 20) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            koly = 20 * 40;
                            g.setColor(Color.GREEN);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, koly + 30);
                            yenikonumy = 20 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                            TasimaSure = (kolUzunluklari[secim - 1]-(20-yenikonumy/40)) / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                        }
                        System.out.println("Yükü taşımak istediğiniz konum kol uzunlugunu aşıyor... ");
                        g.setColor(Color.BLACK);
                        g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                        koly = yenikonumy + kolciz;
                        g.setColor(Color.GREEN);
                        g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, koly + 30);
                        System.out.println("Yük taşınıyor...");
                        g.setColor(Color.RED);
                        g.fillOval(22 + yenikonumx, 22 + koly, 16, 16);
                        TasimaSure = kolUzunluklari[secim - 1] / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                        break;
                    } else if (ileri <= (kolciz / 40)) {
                        if ((yenikonumy / 40) + ileri > 20) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            koly = 20 * 40;
                            g.setColor(Color.GREEN);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, koly + 30);
                            yenikonumy = 20 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(23 + yenikonumx, 23 + yenikonumy, 16, 16);
                            TasimaSure =ileri-( 20-(yenikonumy/40))/ tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                            
                        }
                        g.setColor(Color.GREEN);
                        koly = yenikonumy + (ileri * 40);
                        g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, koly + 30);
                        TasimaSure = ileri / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                    }

                    System.out.println("Sağa: ");
                    int sag = input.nextInt();
                    if (sag > (kolciz / 40)) {
                        if ((yenikonumx / 40) + (kolciz / 40) > 20) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            kolx = 20 * 40;
                            g.setColor(Color.GREEN);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, kolx + 30, yenikonumy + 30);
                            yenikonumx = 20 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                            TasimaSure = (kolUzunluklari[secim - 1]-(20-yenikonumx/40)*10) / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                        }
                        System.out.println("Yükü taşımak istediğiniz konum kol uzunlugunu aşıyor... ");
                        g.setColor(Color.BLACK);
                        g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                        yenikonumx = yenikonumx + kolciz;
                        System.out.println("Yük taşınıyor...");
                        g.setColor(Color.RED);
                        g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                        g.setColor(Color.YELLOW);
                        g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, yenikonumy + 30);
                        TasimaSure = kolUzunluklari[secim - 1] / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                        break;
                    } else if (ileri + sag <= (kolciz / 40)) {
                        if ((yenikonumx / 40) + sag > 20) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            kolx = 20 * 40;
                            g.setColor(Color.YELLOW);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, kolx + 30, yenikonumy + 30);
                            yenikonumx = 20 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                            TasimaSure = ileri+sag-(20-(yenikonumx/40)*10)/ tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                        }
                        g.setColor(Color.YELLOW);
                        kolx = yenikonumx + (sag * 40);
                        g.drawLine(yenikonumx + 30, koly + 30, kolx + 30, koly + 30);
                        TasimaSure = (ileri+sag)*10 / tasimaHizlari[secim - 1];
                        if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                        if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                    }
                    System.out.println("Sola: ");
                    int sol = input.nextInt();
                    if (sol > (kolciz / 40)) {
                        if ((yenikonumx / 40) - (kolciz / 40) < 1) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            kolx = 0 * 40;
                            g.setColor(Color.GREEN);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, kolx + 30, yenikonumy + 30);
                            yenikonumx = 0 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                            TasimaSure =kolUzunluklari[secim-1]-(kolUzunluklari[secim - 1]-(yenikonumx/40)*10) / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                        }
                        System.out.println("Yükü taşımak istediğiniz konum kol uzunlugunu aşıyor... ");
                        g.setColor(Color.BLACK);
                        g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                        yenikonumx = yenikonumx - kolciz;
                        System.out.println("Yük taşınıyor...");
                        g.setColor(Color.RED);
                        g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                        g.setColor(Color.YELLOW);
                        g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, yenikonumy + 30);
                        TasimaSure = kolUzunluklari[secim - 1] / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                        break;
                    } else if (ileri + sag + sol <= (kolciz / 40)) {
                        if ((yenikonumx / 40) - sol < 1) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            kolx = 0 * 40;
                            g.setColor(Color.YELLOW);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, kolx + 30, yenikonumy + 30);
                            yenikonumx = 0 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                            TasimaSure = ileri+sag+sol-(ileri+sag+sol-(yenikonumx/40)*10)/ tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                        }
                        g.setColor(Color.YELLOW);
                        kollx = kolx - (sol * 40);
                        g.drawLine(kolx + 30, koly + 30, kollx + 30, koly + 30);
                        TasimaSure = ileri+sag+sol/tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                    }
                    System.out.println("Geri: ");
                    int geri = input.nextInt();
                    input.nextLine();
                    if (geri > (kolciz / 40)) {
                        if ((yenikonumy / 40) - (kolciz / 40) < 1) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            koly = 0 * 40;
                            g.setColor(Color.GREEN);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, koly + 30);
                            yenikonumy = 0 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                            TasimaSure = kolUzunluklari[secim - 1]-(kolUzunluklari[secim-1]-(yenikonumy/40)*10) / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                        }
                        System.out.println("Yükü taşımak istediğiniz konum kol uzunlugunu aşıyor... ");
                        g.setColor(Color.BLACK);
                        g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                        yenikonumy = yenikonumy - kolciz;
                        System.out.println("Yük taşınıyor...");
                        g.setColor(Color.RED);
                        g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                        g.setColor(Color.YELLOW);
                        g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, yenikonumy + 30);
                        TasimaSure = kolUzunluklari[secim - 1] / tasimaHizlari[secim - 1];
                        if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                        if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                        break;
                    } else if (ileri + sag + sol + geri <= (kolciz / 40)) {
                        if ((yenikonumy / 40) - geri < 1) {
                            System.out.println("Robot kolu ızgaranının dışına çıktığı için program sonlandi.");
                            g.setColor(Color.BLACK);
                            g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                            koly = 0 * 40;
                            g.setColor(Color.YELLOW);
                            g.drawLine(yenikonumx + 30, yenikonumy + 30, yenikonumx + 30, koly + 30);
                            yenikonumy = 0 * 40;
                            g.setColor(Color.RED);
                            g.fillOval(22 + yenikonumx, 22 + yenikonumy, 16, 16);
                            TasimaSure = kolUzunluklari[secim - 1]-(ileri+sag+sol-(yenikonumy/40)*10) / tasimaHizlari[secim - 1];
                            if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                            if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                            break;
                        }
                        g.setColor(Color.YELLOW);
                        kolly = koly - (geri * 40);
                        g.drawLine(kollx + 30, koly + 30, kollx + 30, kolly + 30);
                        TasimaSure = (ileri+sag+sol+geri) / tasimaHizlari[secim - 1];
                        if (diziRs[secim - 1].equalsIgnoreCase("tekerlekli paralel") || diziRs[secim - 1].equalsIgnoreCase("tekerlekli seri") || diziRs[secim - 1].equalsIgnoreCase("spider paralel") || diziRs[secim - 1].equalsIgnoreCase("spider seri") || diziRs[secim - 1].equalsIgnoreCase("paletli paralel") || diziRs[secim - 1].equalsIgnoreCase("paletli spider")) {
                                System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + sabitlenmeSureleri[secim - 1] + gecikmeSureleri[secim - 1] + TasimaSure + " 'sn dir.");
                            }
                        if (diziRs[secim - 1].equalsIgnoreCase("seri")||diziRs[secim - 1].equalsIgnoreCase("paralel")) {
                                 System.out.println(diziRs[secim - 1] + " robotunun başlangıç konumundan sonkonuma geçen süre: " + GezinmeSure + (engeldenGecmeSureleri[secim - 1] * atlananengels) + TasimaSure + " 'sn dir.");
                            }
                        break;
                    }

                    if (ileri + (yenikonumy / 40) - geri <= 20 && ileri + (yenikonumy / 40) - geri > 0 && (yenikonumx / 40) + sag - sol > 0 && (yenikonumx / 40) + sag - sol <= 20) {

                        //if(<=(kolciz/40)){
                        g.setColor(Color.BLACK);
                        g.fillOval(17 + yenikonumx, 17 + yenikonumy, 26, 26);
                        g.setColor(Color.RED);
                        g.fillOval(kollx + 23, kolly + 23, 16, 16);

                    }
                }
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GraphicsDemo.class.getName()).log(Level.SEVERE, null, ex);
            }

            g.clearRect(17 + yenikonumx, 17 + yenikonumy, 26, 26);
            for (i = 0; i < engelS; i++) {
                g.clearRect(17 + engellerx[i], 17 + engellery[i], 26, 26);
            }
            input.nextLine();
            if (RSayisi > 1 && RSayisi >= n) {
                n++;
                repaint();//Robot kollarını sildirebilmek için koydum
            }
        }
///////////////////////////////////////////////////////////////////////////////
        //engelciz(g);
        //robotciz(g);
        //}
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Robot Programına Hoşgeldiniz...");
        System.out.println("*******************************");
        System.out.print("Kaç Adet Robot Kullanacaksınız : ");
        int robotSayisi;
        robotSayisi = input.nextInt();
        input.nextLine();
        String[] diziRobot = new String[robotSayisi];
        double[] kolUzunluklari = new double[robotSayisi];

        double[] engeldenGecmeSureleri = new double[robotSayisi];
        int[] sabitlenmeSureleri = new int[robotSayisi];//gonderildi
        int[] gecikmeSureleri = new int[robotSayisi];//gonderildi
        double[] tasimaHizlari = new double[robotSayisi];//gonderildi
        int[] gezinmeHizlari = new int[robotSayisi];//gonderildi

        for (int i = 0; i < robotSayisi; i++) {//Genel Döngü(KAç tane istersen o kadar girebilir robot) 
            System.out.print("\n");
            System.out.print("Kullanmak İstediğiniz Robot Türünü Giriniz : (Gezgin/Manipülatör/Hibrit)");
            String robotT;//Robot turu
            robotT = input.nextLine();
            System.out.println(robotT.toUpperCase() + " Robot Turunu Sectiniz...");

//GEZGİN ROBOTLAR
            if (robotT.equalsIgnoreCase("Gezgin")) {
                System.out.print("Robotunuzun Motor Sayisini Giriniz : ");
                int motorS;//motor sayısı
                motorS = input.nextInt();
                System.out.print("Robotun Taşıyacağı yuk miktarını giriniz : ");
                double yukM;//yuk miktarı
                yukM = input.nextInt();
                input.nextLine();
                System.out.println("*************************\n");
                System.out.print("Kullanacağınız Gezgin Robot Türünü Giriniz (Spider/Paletli/Tekerlekli): ");
                String Gezgin_robotT;
                Gezgin_robotT = input.nextLine();
                diziRobot[i] = Gezgin_robotT;

//SPİDER
                if (Gezgin_robotT.equalsIgnoreCase("Spider")) {
                    System.out.print("Sectiğiniz Spider Robotun Bacak Sayisini Giriniz : ");
                    int bacakS;
                    bacakS = input.nextInt();
                    System.out.print("Sectiğiniz Spider Robotun Gezinme Hızını Giriniz(1-10 m/s) : ");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 10) {
                            break;
                        } else {
                            System.out.println("Spider Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-10 m/s)...");
                            System.out.print("Gezinme Hızı : ");
                        }
                    }
                    Spider spider = new Spider(motorS, yukM, robotT, gezinmeHizlari[i], bacakS);
                    spider.bilgileriGoster(motorS, yukM, robotT);

//PALETLİ
                } else if (Gezgin_robotT.equalsIgnoreCase("Paletli")) {
                    System.out.println("Sectiğiniz Paletli Robotun Palet Sayisini Giriniz :");
                    int paletS;
                    paletS = input.nextInt();
                    input.nextLine();
                    System.out.print("Paletli Robotun Hız Aralığı Bir Hız Değeri Giriniz (1-50) : ");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        input.nextLine();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 50) {
                            break;
                        } else {
                            System.out.println("Paletli Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-50)...");
                            System.out.print("Gezinme hızı:");
                        }
                    }
                    Paletli paletli = new Paletli(motorS, yukM, robotT, gezinmeHizlari[i], paletS);

                    engeldenGecmeSureleri[i] = paletli.EngelGecmeSuresiBul(motorS);
                    paletli.bilgileriGoster(motorS, yukM, robotT);
                    System.out.println("Engelden Gecebilme Suresi: " + engeldenGecmeSureleri[i]);
                } //TEKERLEKLİ
                else if (Gezgin_robotT.equalsIgnoreCase("Tekerlekli")) {
                    System.out.println("Sectiğiniz Tekerlekli Robotun Tekerlek Sayisini Giriniz : ");
                    int tekerlekS;
                    tekerlekS = input.nextInt();
                    System.out.println("Tekerlekli Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-100)");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        input.nextLine();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 100) {
                            break;
                        } else {
                            System.out.println("Tekerlekli Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-100)...");
                            System.out.println("Gezinme Hızı : ");
                        }
                    }
                    Tekerlekli tekerlekli = new Tekerlekli(tekerlekS, motorS, yukM, robotT, gezinmeHizlari[i]);
                    double engelS;
                    engeldenGecmeSureleri[i] = tekerlekli.EngelGecmeSuresiBul(motorS);
                    tekerlekli.bilgileriGoster(motorS, yukM, robotT);
                    System.out.println("Engelden Gecebilme Suresi: " + engeldenGecmeSureleri[i]);
                } else {
                    System.out.println("Gezgin Robot Turunde " + Gezgin_robotT + " Turunde Bir Robot Bulunmamaktadir.");
                    System.exit(0);
                }
            } //MANİPULATOR
            else if (robotT.equalsIgnoreCase("Manipulator")) {
                System.out.print("Robotunuzun Motor Sayisini Giriniz : ");
                int motorS;//motor sayısı
                motorS = input.nextInt();
                System.out.print("Robotun Taşıyacağı yuk miktarını giriniz : (Seri Robot: max:100 - Paralel Robot: max:500) ");
                double yukM;//yuk miktarı
                yukM = input.nextDouble();
                input.nextLine();
                System.out.println("*********************************\n");
                System.out.print("Kullanacağınız Manipulator Robot Turunu Giriniz (Seri/Paralel):");
                String Manipulator_RobotT;
                Manipulator_RobotT = input.nextLine();
                diziRobot[i] = Manipulator_RobotT;

//SERİ
                if (Manipulator_RobotT.equalsIgnoreCase("Seri")) {

                    double yukK = 100;
                    if (yukK < yukM) {
                        System.out.println("Sectiginiz Seri Manipulator Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Kullanacaginiz Seri Manipulator Robot Turunun Kol Uzunlugunu Giriniz : ");
                    kolUzunluklari[i] = input.nextDouble();
                    input.nextLine();

                    System.out.print("Kullanacaginiz Seri Manipulator Robot Turunun Tasima Hizini Giriniz(1-10 m/s):");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 10) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger!Kullanacaginiz Seri Manipulator Robot Turunun Tasima Hizini Giriniz (1-10m/s) : ");
                        }
                        System.out.print("Tasima Hizi : ");
                    }
                    Seri seri = new Seri(yukK, kolUzunluklari[i], tasimaHizlari[i], motorS, yukM, robotT);
                    seri.bilgileriGoster(robotSayisi, yukK, robotT);
                } //PARALEL
                else if (Manipulator_RobotT.equalsIgnoreCase("Paralel")) {

                    double yukK = 500;//yük kapasitesi
                    if (yukK <= yukM) {
                        System.out.println("Sectiginiz Paralel Manipulator Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Kullanacaginiz Paralel Manipulator Robot Turunun Kol uzunlugunu Giriniz : ");
                    kolUzunluklari[i] = input.nextDouble();
                    input.nextLine();
                    System.out.print("Kullanacaginiz Paralel Manipulator Robot Turunun Tasima Hizini Giriniz (1-50 m/s) : ");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 50) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger Araligi!Kullanacaginiz Paralel Manipulator Robot Turunun Tasima Hizini Giriniz : ");
                            System.out.print("Tasima Hizi :");
                        }
                    }
                    Paralel paralel = new Paralel(yukK, kolUzunluklari[i], tasimaHizlari[i], motorS, yukM, robotT);
                    paralel.bilgileriGoster(robotSayisi, yukK, robotT);
                } else {
                    System.out.println("Manipulator Robot Turunde " + Manipulator_RobotT + " Turunde Bir Robot Bulunamamaktadır.");
                }
            } //HİBRİT
            else if (robotT.equalsIgnoreCase("Hibrit")) {
                System.out.print("Robotun Taşıyacağı yuk miktarını giriniz : ");
                double yukM;//yuk miktarı
                yukM = input.nextInt();
                input.nextLine();
                System.out.print("Robotunuzun Motor Sayisini Giriniz : ");
                int motorS;//motor sayısı
                motorS = input.nextInt();
                System.out.print("Hibrit robot icin hareketli kısmı giriniz:(Spider/Paletli/Tekerlekli) ");
                input.nextLine();
                String HibritR_Hareketli;
                HibritR_Hareketli = input.nextLine();
                System.out.print("Hibrit robot icin hareketsiz kısmı giriniz: (Paralel/Seri) ");
                String HibritR_Hareketsiz;
                HibritR_Hareketsiz = input.nextLine();
                diziRobot[i] = HibritR_Hareketli + " " + HibritR_Hareketsiz;

//SPİDER PARALEL
                if (HibritR_Hareketli.equalsIgnoreCase("Spider") && HibritR_Hareketsiz.equalsIgnoreCase("Paralel")) {
                    double yukK = 500;//yük kapasitesi
                    if (yukK <= yukM) {
                        System.out.println("Sectiginiz Paralel Manipulator Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Sectiğiniz Spider Paralel Robotun Bacak Sayisini Giriniz : ");
                    int bacakS;
                    bacakS = input.nextInt();
                    System.out.print("Sectiğiniz Spider Paralel Robotun Gezinme Hızını Giriniz(1-10 m/s) : ");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 10) {
                            break;
                        } else {
                            System.out.println("Spider Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-10 m/s)...");
                            System.out.print("Gezinme Hızı : ");
                        }
                    }
                    System.out.println("Spider Paralel robotun kol uzunluğunu giriniz: ");
                    kolUzunluklari[i] = input.nextDouble();

                    System.out.print("Kullanacaginiz Spider Paralel Robotun Tasima Hizini Giriniz (1-50 m/s) : ");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 50) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger Araligi!Kullanacaginiz Spider Paralel Robotun Tasima Hizini Giriniz : ");
                            System.out.print("Tasima Hizi :");

                        }

                    }
                    //gecis suresi ve sabitlenme suresi kullanıcıdan al
                    int paletS = 0;
                    int tekerlekS = 0;
                    System.out.print("Kullandiginiz Spider Paralel Robotun Sabitlenme Suresini Giriniz : ");
                    sabitlenmeSureleri[i] = input.nextInt();
                    System.out.print("Kullandiginiz Robotun Spider Robottan Paralel Robota Gecis Suresini Giriniz : ");
                    gecikmeSureleri[i] = input.nextInt();
                    Hibrit hb = new Hibrit(yukK, kolUzunluklari[i], tasimaHizlari[i], gezinmeHizlari[i], bacakS, paletS, tekerlekS, motorS, yukM, robotT, sabitlenmeSureleri[i], gecikmeSureleri[i]);
                    hb.bilgileriGoster(motorS, yukM, robotT);
                } //SPİDER SERİ                
                else if (HibritR_Hareketli.equalsIgnoreCase("Spider") && HibritR_Hareketsiz.equalsIgnoreCase("Seri")) {

                    double yukK = 100;//yük kapasitesi
                    if (yukK <= yukM) {
                        System.out.println("Sectiginiz Paralel Manipulator Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Sectiğiniz Spider Seri Robotun Bacak Sayisini Giriniz : ");
                    int bacakS;
                    bacakS = input.nextInt();
                    System.out.print("Sectiğiniz Spider Seri Robotun Gezinme Hızını Giriniz(1-10 m/s) : ");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 10) {
                            break;
                        } else {
                            System.out.println("Spider Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-10 m/s)...");
                            System.out.print("Gezinme Hızı : ");
                        }
                    }
                    System.out.println("Spider Seri robotun kol uzunluğunu giriniz: ");
                    kolUzunluklari[i] = input.nextDouble();
                    input.nextLine();
                    System.out.println("Spider Seri robotun taşıma hızını giriniz: ");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 10) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger!Kullanacaginiz Seri Manipulator Robot Turunun Tasima Hizini Giriniz : ");
                            System.out.print("Tasima Hizi : ");
                        }
                    }
                    int paletS = 0;
                    int tekerlekS = 0;
                    System.out.print("Kullandiginiz Spider Paralel Robotun Sabitlenme Suresini Giriniz : ");
                    sabitlenmeSureleri[i] = input.nextInt();
                    System.out.print("Kullandiginiz Robotun Spider Robottan Paralel Robota Gecis Suresini Giriniz : ");
                    gecikmeSureleri[i] = input.nextInt();
                    Hibrit hb = new Hibrit(yukK, kolUzunluklari[i], tasimaHizlari[i], gezinmeHizlari[i], bacakS, paletS, tekerlekS, motorS, yukM, robotT, sabitlenmeSureleri[i], gecikmeSureleri[i]);
                    hb.bilgileriGoster(motorS, yukM, robotT);
                } //PALETLİ-PARALEL
                else if (HibritR_Hareketli.equalsIgnoreCase("Paletli") && HibritR_Hareketsiz.equalsIgnoreCase("Paralel")) {

                    double yukK = 500;//yük kapasitesi
                    if (yukK <= yukM) {
                        System.out.println("Sectiginiz Paletli Paralel Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Sectiğiniz Paletli Paralel Robotun Palet Sayisini Giriniz : ");
                    int paletS;
                    paletS = input.nextInt();
                    System.out.print("Sectiğiniz Paletli Paralel Robotun Gezinme Hızını Giriniz(1-50 m/s) : ");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        input.nextLine();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 50) {
                            break;
                        } else {
                            System.out.println("Paletli Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-50)...");
                            System.out.print("Gezinme hızı:");
                        }
                    }
                    System.out.println("Paletli Paralel robotun kol uzunluğunu giriniz: ");
                    kolUzunluklari[i] = input.nextDouble();
                    input.nextLine();
                    System.out.print("Kullanacaginiz Paletli Paralel Robotun Tasima Hizini Giriniz (1-50 m/s) : ");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 50) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger Araligi!Kullanacaginiz Paletli Paralel Robotun Tasima Hizini Giriniz :(1-50 m/s) ");
                            System.out.print("Tasima Hizi :");
                        }

                    }
                    int bacakS = 0;
                    int tekerlekS = 0;
                    System.out.print("Kullandiginiz Spider Paralel Robotun Sabitlenme Suresini Giriniz : ");
                    sabitlenmeSureleri[i] = input.nextInt();
                    System.out.print("Kullandiginiz Robotun Spider Robottan Paralel Robota Gecis Suresini Giriniz : ");
                    gecikmeSureleri[i] = input.nextInt();
                    Hibrit hb = new Hibrit(yukK, kolUzunluklari[i], tasimaHizlari[i], gezinmeHizlari[i], bacakS, paletS, tekerlekS, motorS, yukM, robotT, sabitlenmeSureleri[i], gecikmeSureleri[i]);

                    engeldenGecmeSureleri[i] = hb.EngelGecmeSuresiBul(motorS, "paletli");
                    hb.bilgileriGoster(motorS, yukM, robotT);
                    System.out.println("Engelden Gecebilme Suresi: " + engeldenGecmeSureleri[i]);
                } //PALETLİ-SERİ
                else if (HibritR_Hareketli.equalsIgnoreCase("Paletli") && HibritR_Hareketsiz.equalsIgnoreCase("Seri")) {

                    double yukK = 100;//yük kapasitesi
                    if (yukK <= yukM) {
                        System.out.println("Sectiginiz Paletli Seri Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Sectiğiniz Paletli Seri Robotun Palet Sayisini Giriniz : ");
                    int paletS;
                    paletS = input.nextInt();
                    System.out.print("Sectiğiniz Paletli Seri Robotun Gezinme Hızını Giriniz(1-50 m/s) : ");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        input.nextLine();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 50) {
                            break;
                        } else {
                            System.out.println("Paletli Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-50 m/s)...");
                            System.out.print("Gezinme hızı:");
                        }
                    }
                    System.out.println("Paletli Seri robotun kol uzunluğunu giriniz: ");
                    kolUzunluklari[i] = input.nextDouble();
                    input.nextLine();
                    System.out.print("Kullanacaginiz Paletli Seri Robotun Tasima Hizini Giriniz (1-10 m/s) : ");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 10) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger Araligi!Kullanacaginiz Paletli Seri Robotun Tasima Hizini Giriniz :(1-10 m/s) ");
                            System.out.print("Tasima Hizi :");
                        }
                    }
                    int bacakS = 0;
                    int tekerlekS = 0;
                    System.out.print("Kullandiginiz Spider Paralel Robotun Sabitlenme Suresini Giriniz : ");
                    sabitlenmeSureleri[i] = input.nextInt();
                    System.out.print("Kullandiginiz Robotun Spider Robottan Paralel Robota Gecis Suresini Giriniz : ");
                    gecikmeSureleri[i] = input.nextInt();
                    Hibrit hb = new Hibrit(yukK, kolUzunluklari[i], tasimaHizlari[i], gezinmeHizlari[i], bacakS, paletS, tekerlekS, motorS, yukM, robotT, sabitlenmeSureleri[i], gecikmeSureleri[i]);

                    engeldenGecmeSureleri[i] = hb.EngelGecmeSuresiBul(motorS, "paletli");
                    hb.bilgileriGoster(motorS, yukM, robotT);
                    System.out.println("Engelden Gecebilme Suresi: " + engeldenGecmeSureleri[i]);
                } //TEKERLEKLİ-PARALEL
                else if (HibritR_Hareketli.equalsIgnoreCase("Tekerlekli") && HibritR_Hareketsiz.equalsIgnoreCase("Paralel")) {

                    double yukK = 500;//yük kapasitesi
                    if (yukK <= yukM) {
                        System.out.println("Sectiginiz Tekerlekli Paralel Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Sectiğiniz Tekerlekli Paralel Robotun Tekerlek Sayisini Giriniz : ");
                    int tekerlekS;
                    tekerlekS = input.nextInt();
                    System.out.println("Sectiğiniz Tekerlekli Paralel Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-100)");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        input.nextLine();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 100) {
                            break;
                        } else {
                            System.out.println("Sectiğiniz Tekerlekli Paralel Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-100)...");
                            System.out.println("Gezinme Hızı : ");
                        }
                    }
                    System.out.println("Sectiğiniz Tekerlekli Paralel robotun kol uzunluğunu giriniz: ");
                    kolUzunluklari[i] = input.nextDouble();
                    input.nextLine();
                    System.out.print("Sectiğiniz Tekerlekli Paralel Robotun Tasima Hizini Giriniz (1-50 m/s) : ");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 50) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger Araligi! Sectiğiniz Tekerlekli Paralel Robotun Tasima Hizini Giriniz :(1-50 m/s) ");
                        }
                        System.out.print("Tasima Hizi :");

                    }
                    int bacakS = 0;
                    int paletS = 0;
                    System.out.print("Kullandiginiz Spider Paralel Robotun Sabitlenme Suresini Giriniz : ");
                    sabitlenmeSureleri[i] = input.nextInt();
                    System.out.print("Kullandiginiz Robotun Spider Robottan Paralel Robota Gecis Suresini Giriniz : ");
                    gecikmeSureleri[i] = input.nextInt();
                    Hibrit hb = new Hibrit(yukK, kolUzunluklari[i], tasimaHizlari[i], gezinmeHizlari[i], bacakS, paletS, tekerlekS, motorS, yukM, robotT, sabitlenmeSureleri[i], gecikmeSureleri[i]);

                    hb.bilgileriGoster(motorS, yukM, robotT);
                    engeldenGecmeSureleri[i] = hb.EngelGecmeSuresiBul(motorS, "tekerlekli");
                    System.out.println("Engelden Gecebilme Suresi : " + engeldenGecmeSureleri[i]);
                } //TEKERLEKLİ-SERİ
                else if (HibritR_Hareketli.equalsIgnoreCase("Tekerlekli") && HibritR_Hareketsiz.equalsIgnoreCase("Seri")) {
                    double yukK = 100;//yük kapasitesi
                    if (yukK <= yukM) {
                        System.out.println("Sectiginiz Tekerlekli Seri Robot Bu Yuku Kaldiramaz...");
                        System.exit(0);
                    }
                    System.out.print("Sectiğiniz Tekerlekli Seri Robotun Tekerlek Sayisini Giriniz : ");
                    int tekerlekS;
                    tekerlekS = input.nextInt();
                    System.out.println("Sectiğiniz Tekerlekli Seri Robotun Hız Aralığında Bir Gezinme Hızı Giriniz (1-100)");

                    while (true) {
                        gezinmeHizlari[i] = input.nextInt();
                        input.nextLine();
                        if (gezinmeHizlari[i] > 0 && gezinmeHizlari[i] <= 100) {
                            break;
                        } else {
                            System.out.println("Sectiğiniz Tekerlekli Seri Robotun Hız Aralığında Bir Hız Değeri Giriniz (1-100)...");
                            System.out.println("Gezinme Hızı : ");
                        }
                    }
                    System.out.println("Sectiğiniz Tekerlekli Seri robotun kol uzunluğunu giriniz: ");
                    kolUzunluklari[i] = input.nextDouble();
                    input.nextLine();
                    System.out.print("Sectiğiniz Tekerlekli Seri Robotun Tasima Hizini Giriniz (1-10 m/s) : ");

                    while (true) {
                        tasimaHizlari[i] = input.nextDouble();
                        input.nextLine();
                        if (tasimaHizlari[i] > 0 && tasimaHizlari[i] <= 10) {
                            break;
                        } else {
                            System.out.println("Yanlis Deger Araligi! Sectiğiniz Tekerlekli Paralel Robotun Tasima Hizini Giriniz :(1-10 m/s) ");
                        }
                        System.out.print("Tasima Hizi :");
                    }
                    int bacakS = 0;
                    int paletS = 0;

                    System.out.print("Kullandiginiz Spider Paralel Robotun Sabitlenme Suresini Giriniz : ");
                    sabitlenmeSureleri[i] = input.nextInt();
                    System.out.print("Kullandiginiz Robotun Spider Robottan Paralel Robota Gecis Suresini Giriniz : ");
                    gecikmeSureleri[i] = input.nextInt();
                    Hibrit hb = new Hibrit(yukK, kolUzunluklari[i], tasimaHizlari[i], gezinmeHizlari[i], bacakS, paletS, tekerlekS, motorS, yukM, robotT, sabitlenmeSureleri[i], gecikmeSureleri[i]);
                    hb.bilgileriGoster(motorS, yukM, robotT);
                    engeldenGecmeSureleri[i] = hb.EngelGecmeSuresiBul(motorS, "tekerlekli");
                    System.out.println("Engelden Gecebilme Suresi : " + engeldenGecmeSureleri[i]);

                } else {
                    System.out.println("Hibrit robot türünde olmayan Bir Robot Turu Sectiniz...");
                    System.exit(0);
                }
            } else {
                System.out.println("Olmayan Bir Robot Turu Sectiniz...");
                System.exit(0);
            }
            if (robotSayisi > 1) {
                System.out.println("Simülasyon oluşturuluyor...Devam etmek için herhangi bir tuşa basınız.");
                input.nextLine();
            }
            System.out.println("*********************");
        }

        JFrame jf = new JFrame();
        GraphicsDemo demo = new GraphicsDemo(robotSayisi, diziRobot, kolUzunluklari, gezinmeHizlari, tasimaHizlari, sabitlenmeSureleri, gecikmeSureleri, engeldenGecmeSureleri);
        jf.add(demo);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(1000, 1200);
        jf.setVisible(true);
        jf.getContentPane().validate();
        jf.getContentPane().repaint();

    }
}
