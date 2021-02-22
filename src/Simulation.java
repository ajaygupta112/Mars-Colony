import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulation
{
    public ArrayList<Rocket> loadU1(ArrayList<Item> items)
    {
        ArrayList<Rocket> rocketU1s = new ArrayList<>();
        RocketU1 u1 = new RocketU1(100,10,18);
        int flag = 0;
        for(Item item:items)
        {
            if(u1.canCarry(item))
            {
                flag = 1;
                u1.carry(item);
            }

            else
            {
                flag = 0;
                rocketU1s.add(u1);
                u1 = new RocketU1(100,10,18);
                u1.carry(item);
            }
        }
        if(flag == 1)
            rocketU1s.add(u1);

        return rocketU1s;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items)
    {
        ArrayList<Rocket> rocketU2s = new ArrayList<>();
        RocketU2 u2 = new RocketU2(120,18,29);
        int flag = 0;
        for(Item item:items)
        {
            if(u2.canCarry(item))
            {
                flag = 1;
                u2.carry(item);
            }
            else
            {
                flag = 0;
                rocketU2s.add(u2);
                u2 = new RocketU2(100,10,18);
                u2.carry(item);
            }
        }
        if(flag == 1)
            rocketU2s.add(u2);

        return rocketU2s;
    }

    public ArrayList<Item> loadItems(File file)
    {
        Scanner scanner = null;
        ArrayList<Item> items = new ArrayList();
        try
        {
            scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                String name = scanner.nextLine();
                String[] key_value = name.split("=");
                Item item = new Item(key_value[0],(Integer.parseInt(key_value[1]))/1000);
                items.add(item);
            }
        }
        catch(IOException io)
        {
            System.out.println(io);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return items;
    }

    public int runSimulation(ArrayList<Rocket> rockets)
    {
        int cost = 0;
        for(Rocket rocket:rockets)
        {
            while(rocket.launch() == false || rocket.land() == false)
            {
                cost = cost + rocket.getCost();
            }
            cost = cost + rocket.getCost();

        }
        return cost;
    }
}
