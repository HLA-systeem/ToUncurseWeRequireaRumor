package nl.hr.touncursewerequirearumor.scenes.managers;

import nl.hr.touncursewerequirearumor.scenes.managers.battle_states.BattleState;

public class BattleManager {
    private BattleState battleState;

    public BattleState getBattleState(){
        return this.battleState;
    }

    public void setBattleState(BattleState battleState){
        this.battleState = battleState;
    }

    public void addText(String text){
        Runnable delayText = new DrawVNstyle(text);
        Thread t = new Thread(delayText);
        t.start();
    }
}
