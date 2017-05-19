package nl.hr.touncursewerequirearumor.scenes.managers.battle_states;

import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;

public abstract class BattleState {
    protected BattleManager manager;
    protected Player player;
    protected Enemy enemy;

    BattleState(BattleManager manager,Player player, Enemy enemy) {
        this.manager = manager;
        this.player = player;
        this.enemy = enemy;
    }

    public abstract void execute();
}
