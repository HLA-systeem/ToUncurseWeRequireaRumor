package nl.hr.touncursewerequirearumor.scenes.managers;

import java.util.Random;

import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.ItemScene;
import nl.hr.touncursewerequirearumor.scenes.Scene;

public class SearchResultSeletor {
    private Scene searchResult;
    private SceneManager sceneManager;

    public SearchResultSeletor(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }

    public Scene selectSearchResult(){
        Random random = new Random();
        int outcome = random.nextInt(100) + 1;
        if(outcome <= 50){
            this.searchResult = new BattleScene(this.sceneManager);
        }

        else{
            this.searchResult = new ItemScene(this.sceneManager);
        }

        return this.searchResult;
    }
}
