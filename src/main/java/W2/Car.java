package W2;
import java.util.Random;


public class Car {
    private String name;
    private int position=0;

    public Car(String name){
        this.name=name;
    }

    public void tryMove(){
        Random random=new Random();
        if (random.nextInt(10)>=4){
            this.position++;
        }
    }
    //자동차 이름 정보 출력 메소드
    public void printCarInfo(){
        System.out.printf("%s : %d\n",this.name,this.position);
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.name;
    }

}