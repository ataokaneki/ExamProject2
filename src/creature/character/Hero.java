package creature.character;
import creature.Creature;
import creature.Character;
import weapon.*;

public class Hero extends Character{

    public void attack(Creature target){
        System.out.println(this.getName() + "は" + this.getWeapon() + weapon.attackMessage() + target.getName() + "に10のダメージを与えた！");
        target.setHp(target.getHp()-10);
    }

    public Hero(String name, int hp, Sword sword){
        super(name, hp, sword);
    }
}
