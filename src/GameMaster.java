import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

import creature.*;
import creature.Character;
import creature.character.*;
import creature.monster.*;

public class GameMaster {
    public static void main(String[] args) {
        ArrayList<Character> party = new ArrayList<>();
        party.add(new Hero("勇者", 100));  //引数2つにしたけどだめじゃね
        party.add(new Wizard("魔法使い", 60, 20));
        party.add(new Thief("盗賊", 70));

        //次の変数けしたい
        int m=0;
        int g=0;
        int s=0;

        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            switch((int)(Math.random()*3+1)){
                case 0:
                    monsters.add(new Matango(45,(char)('A'+m)));
                    m++;
                    break;
                case 1:
                    monsters.add(new Goblin(50,(char)('A'+g)));
                    g++;
                    break;
                case 2:
                    monsters.add(new Slime(40,(char)('A'+s)));
                    s++;
                    break;
            }

        }
        monsters.add(new Matango(45, 'A'));
        monsters.add(new Goblin(50, 'A'));
        monsters.add(new Slime(40, 'A'));

        /*
        Iterator<Monster> mIt = monsters.iterator();
        Iterator<Character> cIt = party.iterator();*/

        while(!monsters.isEmpty() || !party.isEmpty()){  //死んで抜ける処理書いてないからエラー吐いてるだけだよ
            Iterator<Monster> mIt = monsters.iterator();
            Iterator<Character> cIt = party.iterator();

            System.out.println("---味方パーティ---");
            for (Character character : party) {
                character.showStatus();
            }
            System.out.println("---敵グループ---");
            for (Monster monster : monsters) {
                monster.showStatus();
            }

            for (Character character : party) {

                }
            }

        }
    }