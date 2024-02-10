package metoda_join;

class mojWatek implements Runnable
{
    int licznik;
    Thread wtk;

    //tworzenie nowego watku
    mojWatek(String name)
    {
        wtk = new Thread(this, name);
        licznik = 0;
        wtk.start();
    }

    //poczatek wykonywania nowego watku
    @Override
    public void run()
    {
        System.out.println(wtk.getName() + " startuje.");
        try
        {
            do {
                Thread.sleep(500);
                System.out.println(wtk.getName() + " startuje." + licznik);
                licznik++;
            }while(licznik < 10);
        }
        catch(InterruptedException exc)
        {
            System.out.println(wtk.getName() + " przerwany.");
        }
        System.out.println(wtk.getName() + " zakonczony.");
    }
}
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Glowny watek startuje.");

        //Tworzenie i poczatek wykonywaia trzech watkow
        mojWatek mw1 = new mojWatek("watek 1");
        mojWatek mw2 = new mojWatek("watek 2");
        mojWatek mw3 = new mojWatek("watek 3");

        try
        {
            //oczekiwanie dopoki nie zakoncza sie okreslone watki
            mw1.wtk.join();
            System.out.println("Watek 1 dolaczyl");
            mw2.wtk.join();
            System.out.println("Watek 2 dolaczyl");
            mw3.wtk.join();
            System.out.println("Watek 3 dolaczyl");
        }
        catch(InterruptedException exc)
        {
            System.out.println("Glowny watek zostal przerwany.");
        }

        System.out.println("Glowny watek zostal zakonczony.");
    }
}
