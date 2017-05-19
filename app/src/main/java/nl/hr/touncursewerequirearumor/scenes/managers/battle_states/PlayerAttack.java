package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;


import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;
import nl.hr.touncursewerequirearumor.scenes.managers.DrawVNstyle;

public class PlayerAttack extends BattleState{


    public PlayerAttack(BattleManager manager, Player player, Enemy enemy) {
        super(manager, player, enemy);
    }

    @Override
    public void execute() {
        BattleScene.clearBattleInfo();
        int damage = player.dealDamage();
        if(enemy.registerHit(player.getHit())) {
            manager.addText(enemy.onDamage(damage));
        }
        else{
            manager.addText("You've missed!");
        }
        manager.setBattleState(new EnemyAttack(manager, player, enemy));
    }
}
