package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;

import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;


public class Encounter extends BattleState{

    public Encounter(BattleManager manager, Player player, Enemy enemy) {
        super(manager, player, enemy);
        this.execute();
    }

    @Override
    public void execute() {
        BattleScene.clearBattleInfo();
        manager.addText(enemy.showsUpText());
    }
}
