package W2;
import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    ArrayList<Car> cars=new ArrayList<>();
    int trial;


    //레이스 정보 출력
    public void printRaceInfo(){
        System.out.printf("시도 회수 : %d",trial);
        for (int i=0;i<cars.size();i++){
            cars.get(i).printCarInfo();
        }
    }

    public Race(){

    }

    //경주 세팅 메소드
    public void setRace(Scanner sc){
        setCars(sc);
        setTrial(sc);
    }

    //시도 회수 세팅 메소드
    private void setTrial(Scanner sc) {
        try{
            System.out.println("시도 회수 입력 :");
            this.trial=sc.nextInt();
        }
        catch (Exception e){
            throw new IllegalArgumentException("잘못된 입력");
        }
    }

    //자동차 이름 세팅 메소드
    public void setCars(Scanner sc){
        System.out.println("경주에 참가할 자동차 이름 입력(구분은 쉼표(,)):");
        String[] input=(sc.nextLine()).split(",");
        for (int i=0; i<input.length;i++){
            cars.add(new Car(input[i]));
        }
    }



    public void doRace(){

    }
}
