package weapon;

public class Wand extends Weapon{
    public String attackMessage(){
        this.setCost(5);
        return "から魔法を放った！";
    }

    public Wand() {
        super("魔法の杖", 15);
        this.setCost(5);
    }
}
