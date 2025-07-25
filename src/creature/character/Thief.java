package creature.character;

import creature.Creature;
import creature.Character;
import weapon.*;

public class Thief extends Character{
    public boolean getGuard() {
        return guard;
    }
    public void setGuard(boolean guard) {
        this.guard = guard;
    }

    private boolean guard;
    public void attack(Creature target){
        System.out.println(this.getName() + getWeapon().attackMessage() + target.getName() + "に"+getWeapon().getDamage()*2+"のダメージを与えた！");
        //盗賊は素早く二回切り付けた
        target.setHp(target.getHp() - getWeapon().getDamage()*2);
    }

    public void guard(){
        setGuard(true);
    }

    public void setHp(int hp){
        if(getGuard()){
            System.out.println("しかし、"+this.getName()+"は攻撃を回避し、ダメージが入らなかった！");
        }else{
            super.setHp(hp);
        }
    }

    public Thief(String name, int hp){
        super(name, hp);
        this.setWeapon(new Dagger());
    }
}
