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


        
    }
}
