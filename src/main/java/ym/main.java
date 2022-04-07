package ym;

import lombok.Getter;
import ym.lustigesFortsGame.Controll;

@Getter
public class main {
    private Controll controll;

    public static void main(String args[]){
        new main();
    }

    public main(){
        controll = new Controll();
        controll.creatGame();
    }
}
