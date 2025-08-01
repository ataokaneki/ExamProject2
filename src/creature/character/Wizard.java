package creature.character;

import creature.Character;
import creature.*;
import weapon.*;

public class Wizard extends Character {
    int mp;

    public void setMp(int mp) {
        this.mp = mp;
    }
    public int getMp(){
        return this.mp;
    }

    public void magic(Creature target) {
        if(this.mp > 0){  //this.mp > wand.getCost()じゃないの？
            System.out.println(this.getName() + "は火の玉を放った！" + target.getName() + ((Monster)target).getSuffix() + "に"+getWeapon().getDamage()+"のダメージを与えた！");
            this.mp -= getWeapon().getCost();  //？？？
            target.setHp(target.getHp() - getWeapon().getDamage());
        }else{
            System.out.println("MPが足りない！");
        }
    }

    public void attack(Creature target) {
        System.out.println(getName()+"は石を投げた！"+target.getName()+ ((Monster)target).getSuffix() +"に3のダメージを与えた！");
        target.setHp(target.getHp() - 3);
    }

    public void showStatus() {
        System.out.println(this.getName() + "：HP " + this.getHp()+"、MP " + this.getMp());
    }

    public Wizard(String name, int hp, int mp) {
        super(name, hp);
        this.setMp(mp);
        this.setWeapon(new Wand());
    }
}
