package nl.hr.touncursewerequirearumor;

import java.util.Random;

public class Player {
    private int hp = 20;
    private int att = 5;
    private int speed = 40;
    private int hit = 70;
    private String boost = "None";
    public static Player player;

    private Player(){
        //Just here to make me remember that I have to make constructors private in a sigleton.
    }

    public static synchronized Player getInstance(){ //Hier is de reden waarom ik geen DCL gebruik http://stackoverflow.com/questions/31051353/is-dcl-still-broken
        if(Player.player == null){
            Player.player = new Player();

        }
        return Player.player;
    }

    public void setHp(int Speed){
        this.speed += speed;
    }

    public void setAtt(int Speed){
        this.speed += speed;
    }

    public void setSpeed(int Speed){
        this.speed += speed;
    }

    public void setHit(int Speed){
        this.speed += speed;
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
        this.hp -= damage;
        return "You took " + damage +" damage";
    }
}
