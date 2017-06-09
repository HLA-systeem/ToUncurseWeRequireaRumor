package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;


import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;


public class PlayerAttack extends BattleState{


    public PlayerAttack(BattleManager manager, Player player, Enemy enemy) {
        super(manager, player, enemy);
    }

    @Override
    public void execute() {
        BattleScene.clearBattleInfo();
        int damage = player.dealDamage();
        if(Constants.registerHit(player.getStat(Constants.STATS.ACCURACY))) {
            this.manager.addText(this.enemy.onDamage(damage));
        }
        else{
            manager.addText("You've missed!");
        }

        if(enemy.defeated()){
            this.manager.setBattleState(new Aftermath(this.manager, this.player, this.enemy,"Winner"));
        }
        else{
            this.manager.setBattleState(new EnemyAttack(this.manager, this.player, this.enemy));
        }
    }
}
