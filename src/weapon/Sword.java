package weapon;

public class Sword extends Weapon{
    public String attackMessage(){
        return "で切りつけた！";
    }

    public Sword(){
        super("剣", 10);
    }
}
