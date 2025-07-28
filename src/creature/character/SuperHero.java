package creature.character;
import creature.Creature;

public class SuperHero extends Hero {
    public void attack(Creature target){
        target.setHp(this.getHp()-(int)(getWeapon().getDamage()*2.5));
        System.out.println(this.getName() + "は" + this.getWeapon().getName() + getWeapon().attackMessage() + target.getName() + "に"+(int)(getWeapon().getDamage()*2.5)+"のダメージを与えた！");
    }

    public SuperHero(Hero h) {
        super(h.getName(), h.getHp()-30);
    }
}