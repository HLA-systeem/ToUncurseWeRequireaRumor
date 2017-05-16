package nl.hr.touncursewerequirearumor.scenes.managers;

import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;

public class BattleManager {
    private String battleState = "Init";


    public String getBattleState(){
        return this.battleState;
    }

    public void encounter(Enemy enemy){
        BattleScene.clearBattleInfo();
        this.addText(enemy.showsUpText());
    }

    public void playerAttack(Player player, Enemy enemy){
        BattleScene.clearBattleInfo();
        int damage = player.dealDamage();
        if(enemy.registerHit(player.getHit())) {
            addText(enemy.onDamage(damage));
        }
        else{
            addText("You've missed!");
        }
        this.battleState = "EnemyAtt";
    }

    public void enemyAttack(Player player, Enemy enemy){
        BattleScene.clearBattleInfo();
        addText(player.onDamage(enemy.getAtt()));
        this.battleState = "Init";
    }

    public void run(Player player, Enemy enemy){
        BattleScene.clearBattleInfo();
        if(player.run(enemy.getSpeed())){
            addText("You've managed to get away.");
            this.battleState = "Escaping";
        }
        else{
            addText("You've can't escape!");
            this.battleState = "EnemyAtt";
        }
    }

    private void addText(String text){
        Runnable delayText = new DrawVNstyle(text);
        Thread t = new Thread(delayText);
        t.start();
    }
}
