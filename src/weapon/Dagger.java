package weapon;

public class Dagger extends Weapon{
    public String attackMessage(){
        return "で素早く切りつけた！";
    }

    public Dagger(){
        super("短剣", 6);
    }
}
