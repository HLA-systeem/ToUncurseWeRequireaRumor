package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;

import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;

public class Setup extends BattleState {

    public Setup(BattleManager manager, Player player, Enemy enemy, boolean init) {
        super(manager, player, enemy);
        if(init==true) {
            this.execute();
        }
    }

    @Override
    public void execute() {
        BattleScene.clearBattleInfo();
        manager.addText(this.enemy.showsUpText());
    }
}
