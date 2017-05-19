package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;

import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;

public class Run extends BattleState {

    public Run(BattleManager manager, Player player, Enemy enemy){
        super(manager, player, enemy);

    }

    @Override
    public void execute() {
        BattleScene.clearBattleInfo();
        if(player.run(enemy.getSpeed())){
            manager.addText("You've managed to get away.");
            manager.setBattleState(null);
            //switch to search scene.
        }
        else{
            manager.addText("You've can't escape!");
            manager.setBattleState(new EnemyAttack(manager, player, enemy));
        }
    }
}
