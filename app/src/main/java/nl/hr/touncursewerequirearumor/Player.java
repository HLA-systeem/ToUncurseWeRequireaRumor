package nl.hr.touncursewerequirearumor;

import java.util.Random;

public class Player {
    private int hp = 20; //this is the max health
    private int att = 5;
    private int speed = 40;
    private int hit = 70;

    private String boost = "None";
    public static Player player;
    public int hpCurrent = 20;

    private Player(){
        //Just here to make me remember that I have to make constructors private in a sigleton.
    }

    public static synchronized Player getInstance(){ //Hier is de reden waarom ik geen DCL gebruik http://stackoverflow.com/questions/31051353/is-dcl-still-broken
        if(Player.player == null){
            Player.player = new Player();
        }
        return Player.player;
    }

    public void setBoost(String Boost){
        this.boost = boost;
    }

    public int getHit(){
        return this.hit;
    }


    public boolean run(int enemySpeed){
        Random random = new Random();
        int chance = (this.speed * 50)/enemySpeed;
        int outcome = random.nextInt(100) + 1;
        if(outcome <= (chance)){
            return true;
        }
        else {
            if(this.boost == "Atmosphere"){
                outcome = random.nextInt(100) + 1;
                if (outcome <= (chance)) {
                    return true;
                }
            }
            return false;
        }
    }

    public int dealDamage(){
        int damage = this.att;
        if(this.boost == "Thunderstorm") {
            damage = damage + (this.att/2);
        }
        return damage;
    }

    public String onDamage(int damage){
        this.hpCurrent -= damage;
        return "You took " + damage +" damage";
    }

    public Boolean gameover(){
        if(this.hpCurrent <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int getStat(Constants.STATS stat){
        int statValue = 0;
        switch(stat){
            case HEALTH:
                statValue = this.hp;
                break;
            case ATTACK:
                statValue = this.att;
                break;
            case SPEED:
                statValue = this.speed;
                break;
            case ACCURACY:
                statValue = this.hit;
                break;
        }
        return statValue;
    }

    public void increaseStat(Constants.STATS stat){
        switch(stat){
            case HEALTH:
                this.hp += 20;
                break;
            case ATTACK:
                this.att += 5;
                break;
            case SPEED:
                this.speed += 2;
                break;
            case ACCURACY:
                this.hit += 2;
                break;
        }
    }
}
