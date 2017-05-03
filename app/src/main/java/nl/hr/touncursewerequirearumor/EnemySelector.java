package nl.hr.touncursewerequirearumor;

import java.util.Random;

import nl.hr.touncursewerequirearumor.nl.hr.touncursewerequirearumor.enemies.Enemy;

public class EnemySelector{
    Enemy selectedEnemy;

    public Enemy selectEnemy(){
        Random random = new Random();
        int outcome = random.nextInt(100) + 1;
        if(outcome <= 5){
            this.selectedEnemy = new Atroe();
            return this.selectedEnemy;
        }
        else if(outcome>5 && outcome<=15){
            this.selectedEnemy = new Missnake();
            return this.selectedEnemy;
        }
        else if(outcome>15 && outcome<=25){
            this.selectedEnemy = new InterDimensionalLolicon();
            return this.selectedEnemy;
        }

        else if(outcome>25 && outcome<=45){
            this.selectedEnemy = new WannabeBandit();
            return this.selectedEnemy;
        }
        else{
            this.selectedEnemy = new PlastiCat();
            return this.selectedEnemy;
        }
    }
}

