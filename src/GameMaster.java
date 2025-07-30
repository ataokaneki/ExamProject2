import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int m = 0;
        int g = 0;
        int s = 0;

        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            switch ((int) (Math.random() * 3 + 1)) {
                case 1:
                    monsters.add(new Matango(45, (char) ('A' + m)));
                    m++;
                    break;
                case 2:
                    monsters.add(new Goblin(50, (char) ('A' + g)));
                    g++;
                    break;
                case 3:
                    monsters.add(new Slime(40, (char) ('A' + s)));
                    s++;
                    break;
            }

        }

        while (!monsters.isEmpty() || !party.isEmpty()) {  //死んで抜ける処理書いてないからエラー吐いてるだけだよ

        /*
        Iterator<Monster> mIt = monsters.iterator();
        Iterator<Character> cIt = party.iterator();*/

            while (!monsters.isEmpty() || !party.isEmpty()) {  //死んで抜ける処理書いてないからエラー吐いてるだけだよ
                // Iterator<Monster> mIt = monsters.iterator();
                //Iterator<Character> cIt = party.iterator();

                System.out.println("---味方パーティ---");
                for (Character character : party) {
                    character.showStatus();
                }
                System.out.println("---敵グループ---");
                for (Monster monster : monsters) {
                    monster.showStatus();
                }
                int targetNum;
                int actionNum;

                /*for (Character character : party) {
                    System.out.println("行動：" + character.getName());*/
                try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                    for (Character character : party) {
                        System.out.println("行動：" + character.getName());
                        System.out.print("対象を指定->");
                        String input = br.readLine();
                        targetNum = Integer.parseInt(input);

                        if (character instanceof Hero) {
                            System.out.println("1. 攻撃　2. 進化");
                            System.out.print("行動を選択->");
                            actionNum = Integer.parseInt(br.readLine());
                            switch (actionNum) {
                                case 1:
                                    character.attack(monsters.get(targetNum));
                                    break;

                                case 2:
                                    party.set(1, new SuperHero((Hero) party.get(1)));
                                    break;

                            }

                        } else if (character instanceof Wizard) {
                            System.out.println("1. 攻撃　2. 魔法攻撃");
                            System.out.print("行動を選択->");
                            actionNum = Integer.parseInt(br.readLine());
                            switch (actionNum) {
                                case 1:
                                    character.attack(monsters.get(targetNum));
                                    break;

                                case 2:
                                    ((Wizard) character).magic(monsters.get(targetNum));
                                    break;
                            }
                        } else if (character instanceof Thief) {
                            System.out.println("1. 攻撃　2. 守り");
                            System.out.print("行動を選択->");
                            actionNum = Integer.parseInt(br.readLine());
                            switch (actionNum) {
                                case 1:
                                    character.attack(monsters.get(targetNum));
                                    break;
                                case 2:
                                    ((Thief) character).guard();
                                    break;
                            }
                        }
                        if (!monsters.get(targetNum).isAlive()) {
                            monsters.remove(targetNum);
                        } else if (monsters.get(targetNum).getHp() <= 5) {
                            monsters.get(targetNum).run();
                            monsters.remove(targetNum);
                        }
                        if (monsters.isEmpty()) {
                            break;
                        }
                    }
                    for (Monster monster : monsters) {
                        targetNum = (int) (Math.random() * party.size() + 1);
                        monster.attack(party.get(targetNum));

                        if (!party.get(targetNum).isAlive()) {
                            party.get(targetNum).die();
                            party.remove(targetNum);
                        }

                        if (party.isEmpty()) {
                            break;
                        }
                    }


                } catch (IOException | NullPointerException e) {
                    System.out.println("えらー" + e.getMessage());



         /*

                    if (character instanceof Hero) {
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                            System.out.println("1. 攻撃　2. 進化");
                            System.out.print("行動を選択->");
                            actionNum = Integer.parseInt(br.readLine());
                        } catch(IOException | NullPointerException e){
                            System.out.println("えらー");
                        }
                        switch (actionNum) {
                            case 1:
                                character.attack(monsters.get(targetNum));
                                break; //magic動かん

                            case 2:
                                character = new SuperHero((Hero) party.getFirst());
                                break;
                        }
                    } else if (character instanceof Wizard) {  //予測に出てきたけど.classってなに？
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                            System.out.println("1. 攻撃　2. 魔法攻撃");
                            System.out.print("行動を選択->");
                            actionNum = Integer.parseInt(br.readLine());
                        } catch (Exception e) {
                            System.out.println("行動が存在しないよん");
                        }
                        switch (actionNum) {
                            case 1:
                                character.attack(monsters.get(targetNum));
                                break;

                            case 2:
                                ((Wizard) character).magic(monsters.get(targetNum));
                                break;
                        }
                    } else if (character instanceof Thief) {
                        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                            System.out.println("1. 攻撃　2. 守り");
                            System.out.print("行動を選択->");
                            actionNum = Integer.parseInt(br.readLine());
                        } catch (Exception e) {
                            System.out.println("行動が存在しないよん");
                        }
                        switch (actionNum) {
                            case 1:
                                character.attack(monsters.get(targetNum));
                                break;
                            case 2:
                                ((Thief) character).guard();
                                break;
                        }
                    }

                    if (!monsters.get(targetNum).isAlive()) {
                        monsters.remove(targetNum);
                    } else if (monsters.get(targetNum).getHp() <= 5) {
                        monsters.get(targetNum).run();
                        monsters.remove(targetNum);
                    }
                    if (monsters.isEmpty()) {
                        break;
                    }
                }
*/

                }
                if (monsters.isEmpty()) {
                    System.out.println("敵をすべて倒した！" + Hero.class.getName() + "達は勝利した！");
                } else if (party.isEmpty()) {
                    System.out.println("味方パーティは全滅してしまった……");
                }
            }
        }
    }
}