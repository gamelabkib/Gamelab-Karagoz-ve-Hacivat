package com.ngdroidapp;

import istanbul.gamelab.ngdroid.util.Utils;

public class Animations {
    private Character character = new Character();
    private Nobject object = new Nobject();
    //Nesnenin X ve Y Konumu
    private int objectX, objectY;
    //Hedefin X ve Y Konumu
    private int targetX, targetY;
    //Karakterin X ve Y Konumu
    private int characterX, characterY, characterWidth, characterHeight;

    public Animations(Character character) {
        //Character Sınıfından karakterin X ve Y'sinin çekilmesi
        this.character = character;

        characterX = character.getNobjectdstx();
        characterY = character.getNobjectdstx();
        characterWidth = character.getNobjectdstw();
        characterHeight = character.getNobjectdsth();
        objectX = object.getNobjectdstx();
        objectY = object.getNobjectdsty();
    }

    public boolean Collision() {
    //Objelerin Karşılaştırılması
<<<<<<< Updated upstream
    if(Utils.checkCollision(character.getNobjectdestination(),object.getNobjectdestination())) {
=======
    if(Utils.checkCollision(character.getNobjectdestination(),object.getNobjectdestination()))
        {
>>>>>>> Stashed changes
            return true;
        }
        else{
            return false;
        }

    }

    public boolean AIDefenceCollision()
    {
     if((character.getNobjectdstx()+100)==objectX)
         {
         return true;
         }
     else{
         return false;
         }

<<<<<<< Updated upstream
    public void ShoutAnımation() {
    if(!Collision())
    {
        objectX+= 15;
        object.setNobjectdstx(objectX);
=======

>>>>>>> Stashed changes
    }



    public boolean ShoutAnımation() {

        if (!Collision()) {
            objectX += 15;
            object.setNobjectdstx(objectX);
            return true;
        }

        else{
            return false;
        }


}


}