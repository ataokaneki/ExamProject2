package weapon;

public class Dagger extends Weapon{
    public String attackMessage(){
        //return "で素早く切りつけた！";
        return "で素早く2回攻撃した！";
    }

    public Dagger(){
        super("短剣", 6);
    }
}
