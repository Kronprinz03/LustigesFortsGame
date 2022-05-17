package ym.lustigesFortsGame.Clocks;

import lombok.SneakyThrows;
import ym.lustigesFortsGame.Controll;

public class EnergyClock extends Thread{
    private Controll controll;

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            if(controll.isIngame()&&!(controll.isPause())){
                if(controll.getSpieler1().getEnergy() < 100){
                    Thread.sleep(2000);
                    controll.getSpieler1().setEnergy(controll.getSpieler1().getEnergy()+5);
                }else{
                    System.out.println();
                }

            }else {
                System.out.println();
            }
        }
    }

    public EnergyClock(Controll controll){
        this.controll = controll;
    }
}
