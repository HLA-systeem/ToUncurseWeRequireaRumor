package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;


import java.util.Random;

import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;

public class Aftermath extends BattleState {
    private String result;

    Aftermath(BattleManager manager, Player player, Enemy enemy, String result){
        super(manager, player, enemy);
        this.result = result;
    }

    @Override
    public void execute() {
        BattleScene.clearBattleInfo();
        switch(this.result){
            case "Winner":
                manager.addText("You've defeated the enemy!");
                Random random = new Random();
                int outcome = random.nextInt(100) + 1;
                if(enemy.getName() == "Plasticat" && outcome <= 10){
                    manager.setResult("Plastibat");
                }
                else if(enemy.getName() == "Atroe"){
                    manager.setResult("Atroe");
                }
                else{
                    manager.setResult("Winner");
                }
                break;
            case "Defeated":
                manager.addText("\nYou've been defeated...");
                manager.setResult("Defeated");
                break;
            case "Escaped":
                manager.addText("Bye bye " +enemy.getName());
                manager.setResult("Escaped");
                break;
        }
    }
}
