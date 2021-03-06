package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Character extends Nobject{
    //Karakterin Sağlık durumunu tutar
    private int health;
    //Karakterin kaç kez hasar aldığını tutar
    private int damagecount;
    //Karakterin kaç kez hasar verdiğini tutar
    private int hitcount;
    //Karakterin kaç kez ıskaladığını tutar
    private int misscount;
    //Karakterin mermi sayısını tutar
    private int bulletcount;
    //Karakterin vuruş kontrolü
    private boolean shoutcountrol;
    //Karakterin zıplama kontrolü
    private boolean jumpcontrol;
    //Karakterin yaşayıp yaşamadığını kontrol etmek için oluşturuldu
    private boolean livecontrol;
    //Karakterin eğilme durumunu kontrol eder
    private boolean downcontrol;
    //Karakterin dikey doğrultudaki ivmesi
    private double charAcceleration;
    //Sinüs dalgası için kullanılacak derece charAcceleration yönünü belirleyecek
    private boolean crouchcontrol;
    //Jump sayacı
    private int derece;
    //Crouch sayacı
    private int derececrouch;
    private int counter;

    public Character() {
        health = 100;
        damagecount = 0;
        hitcount = 0;
        misscount = 0;
        bulletcount = 30;
        crouchcontrol=false;
        shoutcountrol=false;
        jumpcontrol = false;
        livecontrol = true;
        downcontrol = false;
        charAcceleration = -5;
        derece=6;
        derececrouch=0;
        counter=0;

    }

    public void setcrouchControl(boolean crouchcontrol) {  this.crouchcontrol=crouchcontrol; }

    public boolean getcrouchControl() {  return crouchcontrol;  }

    public int getBulletcount() {
        return bulletcount;
    }

    public void setBulletcount(int bulletcount) {
        this.bulletcount = bulletcount;
    }

    public void decBulletCount(){
        bulletcount--;
    }
    public boolean isShoutControl() { return shoutcountrol; }

    public void setShoutcountrol(boolean shoutcountrol) {
        this.shoutcountrol = shoutcountrol;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamagecount() {
        return damagecount;
    }

    public void setDamagecount(int damagecount) {
        this.damagecount = damagecount;
    }

    public int getHitcount() {
        return hitcount;
    }

    public void setHitcount(int hitcount) {
        this.hitcount = hitcount;
    }

    public int getMisscount() {
        return misscount;
    }

    public void setMisscount(int misscount) {
        this.misscount = misscount;
    }

    public boolean isJumpcontrol() {
        return jumpcontrol;
    }

    public void setJumpcontrol(boolean jumpcontrol) {
        this.jumpcontrol = jumpcontrol;
    }

    public boolean isLivecontrol() {
        return livecontrol;
    }

    public void setLivecontrol(boolean livecontrol) {
        this.livecontrol = livecontrol;
    }

    public boolean isDowncontrol() {
        return downcontrol;
    }

    public void setDowncontrol(boolean downcontrol) {
        this.downcontrol = downcontrol;
    }

    public double getCharAcceleration() {
        return charAcceleration;
    }


    public void setCharAcceleration(double charAcceleration) {
        this.charAcceleration = charAcceleration;
    }

    public int getDerece() {
        return derece;
    }

    public void setDerece(int derece) {
        this.derece = derece;
    }
    public void incDamageCount(){
        damagecount++;

    }
    public void incHitCount(){
        hitcount++;
    }
    public void incMissCount(){
        misscount++;

    }
    public void decHealth(FruitObject fruitObject){
        if(livecontrol)
            health -= fruitObject.getWeight();
    }

    //ZIPLAMA
    public boolean jump()
    {
        if(!downcontrol && jumpcontrol){

            derece += 6;
            if (derece <= 90) {
                charAcceleration -= Math.sin(Math.toRadians(derece)/180) * 600;
            }
            else if (derece <= 180) {
                charAcceleration += Math.sin(Math.toRadians(derece)/180) * 600;
            }else{
                jumpcontrol =false;
                derece = 6;
                charAcceleration = -5;
                return true;
            }
           setNobjectdsty(getNobjectdsty()+(int)charAcceleration);
        }
        return false;
    }
    public boolean down(){
        if(downcontrol&&!jumpcontrol){
            derece += 6;
            if (derece <= 90) {
                if(derece <= 64){
                    for (;derece <= 64; derece += 6){
                        charAcceleration += Math.sin(Math.toRadians(derece)/180) * 500;
                    }
                }else{
                    charAcceleration += Math.sin(Math.toRadians(derece)/180) * 500;

                }
            }
            else if (derece <= 180) {
                charAcceleration -= Math.sin(Math.toRadians(derece)/180) * 300;
            }else{
                downcontrol =false;
                derece = 6;
                charAcceleration = -5;
                return true;
            }
            setNobjectdsty(getNobjectdsty()+(int)charAcceleration);
        }
        return false;
    }
    //EĞİLME
    public boolean crouch()
    {
        derececrouch+=10;
        if(derececrouch<=50){counter+=8;setNobjectdsty(getNobjectdsty()+counter);}
        if(derececrouch>=51){counter-=8;setNobjectdsty(getNobjectdsty()-counter);}
        if(derececrouch==100)
        {
            derececrouch=0;
        }
      return true;

    }
}
