public class Rocket implements SpaceShip
{
    private int current_weight;
    private int cost;
    private int rocket_weight;
    private int MAX_WEIGHT;

    public Rocket(int cost, int rocket_weight, int MAX_WEIGHT)
    {
        this.cost = cost;
        this.rocket_weight = rocket_weight;
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.current_weight = rocket_weight;
    }
    @Override
    public boolean land()
    {
        return true;
    }

    @Override
    public boolean launch()
    {
        return true;
    }

    @Override
    public boolean canCarry(Item item)
    {
        if((item.getWeight()+getCurrent_weight()) < getMAX_WEIGHT())
            return true;
        return false;
    }

    @Override
    public void carry(Item item)
    {
        setCurrent_weight(item.getWeight());
    }

    private void setCurrent_weight(int weight)
    {
        current_weight = current_weight + weight;
    }

    public int getCurrent_weight()
    {
        return current_weight;
    }

    public int getMAX_WEIGHT()
    {
        return MAX_WEIGHT;
    }

    public int getCost()
    {
        return cost;
    }

    public int getRocket_weight()
    {
        return rocket_weight;
    }

    public int getCargoLimit()
    {
        return getMAX_WEIGHT() - getRocket_weight();
    }
}
