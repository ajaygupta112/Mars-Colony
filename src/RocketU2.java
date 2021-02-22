public class RocketU2 extends Rocket
{
    public RocketU2(int cost, int rocket_weight, int MAX_WEIGHT)
    {
        super(cost, rocket_weight, MAX_WEIGHT);
    }

    @Override
    public boolean land()
    {
        double explosion_chance;
        double random_chance;
        double cargo_ratio = ((double)getCurrent_weight())/getCargoLimit();
        explosion_chance = (8*cargo_ratio)/100;
        random_chance = (Math.random()*cargo_ratio);
        if(random_chance > explosion_chance)
            return true;
        return false;
    }

    @Override
    public boolean launch()
    {
        double explosion_chance;
        double random_chance;
        double cargo_ratio = ((double)getCurrent_weight())/getCargoLimit();
        explosion_chance = (4*cargo_ratio)/100;
        random_chance = (Math.random()*cargo_ratio);
        if(random_chance > explosion_chance)
            return true;
        return false;
    }
}
