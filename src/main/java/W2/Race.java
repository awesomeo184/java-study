package W2;

import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    ArrayList<Car> cars=new ArrayList<>();
    int trial;


    //레이스 정보 출력
    public void printRaceInfo(){
        System.out.printf("시도 회수 : %d\n",trial);
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
        String name;
        for (int i=0; i<input.length;i++){
            name=checkNameValid(input[i],sc);
            cars.add(new Car(name));
        }
    }

    //이름 길이 검사
    private String checkNameValid(String name, Scanner sc) {
        if (name.length()>5) {
            System.out.printf("%s 보다 짧은 이름으로 설정해주세요 : \n",name);
            return checkNameValid(sc.nextLine(),sc);
        }
        return name;
    }


    private void doTrial() {
        for (int i=0; i<this.cars.size() ;i++) {
            cars.get(i).tryMove();
        }
    }

    private void displayRace() {
        for (Car car:cars) {
            System.out.printf("%s : %s\n",car.getCarName(),"-".repeat( car.getPosition()));
        }
        System.out.println();
    }

    public void doRace(){
        for(int i=0;i<this.trial;i++) {
            doTrial();
            displayRace();
        }
    }


    private ArrayList<Car> getWinner(ArrayList<Car> cars) {
        ArrayList<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            winner=checkRecord(car,winner);
        }
        return winner;
    }

    private ArrayList<Car> checkRecord(Car car, ArrayList<Car> winner) {
        ArrayList<Car> temp=new ArrayList<>();
        if (winner.size()==0) {
            temp.add(car);
            return temp;
        }
        else if (winner.get(0).getPosition()==car.getPosition()) {
            winner.add(car);
            return winner;
        }
        else if (winner.get(0).getPosition()<car.getPosition()) {
            temp.add(car);
            return temp;
        }
        return winner;
    }

    private void printWinner(ArrayList<Car> winner) {
        System.out.print("최종 우승자 : ");
        for (Car car:winner) {
            System.out.printf("%s ",car.getCarName());
        }
        System.out.println();
    }

    public void award() {
        printWinner(getWinner(cars));
    }

}