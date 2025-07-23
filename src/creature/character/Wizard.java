package creature.character;

import creature.Character;
import creature.Creature;
import weapon.*;

public class Wizard extends Character {
    int mp;
    Wand wand = new Wand();
    public void setMp(int mp) {
        this.mp = mp;
    }

    public void magic(Creature target) {
        if(this.mp< wand.getCost()){}
    }

    public void attack(Creature target) {

    }

    public Wizard(String name, int hp, int mp) {
        super(name, hp);
        this.setMp(mp);
        this.setWeapon(new Wand());
    }
}
