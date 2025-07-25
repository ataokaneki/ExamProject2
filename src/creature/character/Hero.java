package creature.character;
import creature.Creature;
import creature.Character;
import weapon.*;

public class Hero extends Character{
    //Sword sword = new Sword();

    public void attack(Creature target){
        System.out.println(this.getName() + "は" + this.getWeapon().getName() + getWeapon().attackMessage() + target.getName() + "に10のダメージを与えた！");
        target.setHp(target.getHp()-getWeapon().getDamage());
    }

    public Hero(String name, int hp){
        super(name, hp);
        setWeapon(new Sword());
    }
}
