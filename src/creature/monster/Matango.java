package creature.monster;

import creature.*;

public class Matango extends Monster{
    public void attack(Creature target){
        System.out.println(this.getName()+this.getSuffix()+"は体当たり攻撃！"+target.getName()+"に6のダメージを与えた！");
        target.setHp(target.getHp()-6);
    }

    public Matango(int hp, char suffix){
        super("お化けキノコ", hp, suffix);
    }
}

