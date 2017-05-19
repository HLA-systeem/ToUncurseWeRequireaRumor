package nl.hr.touncursewerequirearumor.scenes.managers;

import nl.hr.touncursewerequirearumor.scenes.managers.battle_states.BattleState;

public class BattleManager {
    private BattleState battleState;
    private String Result;

    public BattleManager(){
        this.Result = "None";
    }

    public BattleState getBattleState(){
        return this.battleState;
    }

    public String getResult(){
        return this.Result;
    }

    public void setResult(String result){
        this.Result = result;
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
