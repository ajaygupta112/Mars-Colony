import java.util.ArrayList;
import java.io.File;
public class Main
{
    public static void main(String[] args)
    {
        String phase1 = "phase-1.txt";
        String phase2 = "phase-2.txt";
        Simulation simulation = new Simulation();

        ArrayList<Item> phase1items = simulation.loadItems(new File("phase-1.txt"));
        ArrayList<Item> phase2items = simulation.loadItems(new File("phase-2.txt"));

        ArrayList<Rocket> phase1u1 = simulation.loadU1(phase1items);
        ArrayList<Rocket> phase2u1 = simulation.loadU1(phase2items);

        int mission_cost = 0;



        mission_cost = mission_cost + simulation.runSimulation(phase1u1);
        System.out.println("Cost of Mission Phase 1 with U1 Rockets : " + mission_cost);
        mission_cost = mission_cost + simulation.runSimulation(phase2u1);
        System.out.println("Cost of Mission with Rockets U1 : " + mission_cost);

        mission_cost = 0;

        ArrayList<Rocket> phase1u2 = simulation.loadU2(phase1items);
        ArrayList<Rocket> phase2u2 = simulation.loadU2(phase2items);

        mission_cost = mission_cost + simulation.runSimulation(phase1u2);
        System.out.println("Cost of Mission Phase 1 with U2 Rockets : " + mission_cost);
        mission_cost = mission_cost + simulation.runSimulation(phase2u2);
        System.out.println("Cost of Mission with Rockets U2 : " + mission_cost);

    }
}
