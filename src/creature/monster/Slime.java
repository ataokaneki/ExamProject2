package creature.monster;

import creature.*;

public final class Slime extends Monster{
    public void attack(Creature target){
        System.out.println(this.getName()+this.getSuffix()+"は体当たり攻撃！"+target.getName()+"に5のダメージを与えた！");
        target.setHp(target.getHp()-5);
    }

    public Slime(int hp, char suffix){
        super("スライム", hp, suffix);
    }
}
