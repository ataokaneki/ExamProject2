package weapon;

public abstract class Weapon {
    private String name;
    private int damage;
    private int cost = 0;

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCost(){
        return this.cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract String attackMessage();

    public Weapon(String name, int damage) {
        this.setName(name);
        this.setDamage(damage);
    }
}
