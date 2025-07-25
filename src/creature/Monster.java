package creature;

public abstract class Monster implements Creature{
    private String name;
    private int hp;
    private char suffix;

    public void run(){
        System.out.println(this.getName() + this.getSuffix() + "は逃げ出した！");
    }

    public void die(){
        System.out.println(this.getName() + this.getSuffix() + "を倒した！");
    }

    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.hp;
    }

    public char getSuffix(){
        return this.suffix;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHp(int hp){
        this.hp = Math.max(0, hp);
    }

    public void setSuffix(char suffix){
        this.suffix = suffix;
    }

    public final boolean isAlive(){
        return this.hp>0;
    }

    public void showStatus(){
        System.out.println(this.getName() + this.getSuffix() + "：HP " + this.getHp());
    }

    public Monster(String name, int hp, char suffix) {
        this.setName(name);
        if(hp < 0){
            throw new IllegalArgumentException("初期設定に誤りがあるため、キャラクターを作成できませんでした");
        }
        this.setHp(hp);
        this.setSuffix(suffix);
    }
}
