package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;

public class EnemyAttack extends BattleState {

    public EnemyAttack(BattleManager manager, Player player, Enemy enemy) {
        super(manager, player, enemy);
    }

    @Override
    public void execute() {
        BattleScene.clearBattleInfo();
        int damage = this.enemy.getAtt();
        if(Constants.registerHit(enemy.getHit())) {
            this.manager.addText(this.player.onDamage(damage));
        }
        else{
            manager.addText("The "+ this.enemy.getName()+" missed!");
        }
        if(player.gameover()){
            this.manager.setBattleState(new Aftermath(this.manager, this.player, this.enemy,"Defeated"));
        }
        else {
            this.manager.setBattleState(new Setup(this.manager, this.player, this.enemy, false));
        }
    }


}
