package nl.hr.touncursewerequirearumor.nl.hr.touncursewerequirearumor.enemies;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

import nl.hr.touncursewerequirearumor.Constants;

public abstract class Enemy{ //An abstract class should not have fields
    protected String name;
    protected String nameRes;
    protected int hp;
    protected int att;
    protected int speed;
    protected int hit;
    protected static String nerf = "None";

    public Enemy(String name,String nameRes,int hp,int att,int speed,int hit){
        this.name = name;
        this.nameRes = nameRes;
        this.hp = hp;
        this.att = att;
        this.speed = speed;
        this.hit = hit;

        switch(Enemy.nerf) {
            case "Snow":
                this.att = att - (att/2);
                break;
            case "Drizzle":
                this.hit = hit - (hit/2);
                break;
            case "Rain":
                this.speed = speed - (speed/2);
                break;
        }
    }


    public Bitmap displayCharacter(){
        BitmapFactory bf = new BitmapFactory();
        Bitmap img = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(this.nameRes,"drawable", "nl.hr.touncursewerequirearumor"));
        return img;
        }

    public String showsUpText(){
        return "A " +  this.name + " appeard !";
        }

    public String onDamage(int damage){
        this.hp -= damage;
        return this.name + " took " + damage + " damage";
        }

    public Boolean registerHit(int hitRate){
        Random random = new Random();
        int chance = hitRate;
        int outcome = random.nextInt(100) + 1;
        if(outcome <= (hitRate)){
            return true;
        }

        else {
            return false;
        }

    }

    public static void setNerf(String nerf){
        Enemy.nerf = nerf;
    }

    public int getAtt(){
        return this.att;
    }

    public int getSpeed(){
        return this.speed;
    }
}
