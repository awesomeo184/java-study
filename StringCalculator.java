import java.util.Scanner;

public class StringCalculator {
    private String expression;
    private boolean cal_switch=true;

    //계산기 전원 확인
    public boolean checkswitch() {
        return cal_switch;
    }

    //문자열 입력받기
    private void inputString() {
        Scanner sc=new Scanner(System.in);
        System.out.println("실행할 연산을 입력해주세요 : ");
        expression=sc.nextLine();
    }

    //문자열 배열화
    private String[] splitString() {
        String[] arr;
        arr=expression.split(" ");
        return arr;
    }

    //수식의 길이가 홀수 인지 확인
    private void isInvalidExp(String[] arr) throws Exception {
        if (arr.length%2==0) {
            throw new Exception("[ERROR] 잘못된 연산식입니다.");
        }
    }

    //입력받은 문자열 exit인지 확인
    private boolean isExit() {
        if (expression.equals("exit")) {
            cal_switch=false;
            return true;
        }
        return false;
    }


    //문자열 계산
    private float calculate(String[] arr) throws Exception {
        float opd1=0, opd2=0;
        String opt="+";
        for (int i=0;i<arr.length;i++) {
            if (i%2==0) {
                opd2=convertToFloat(arr[i]);
                opd1=subcal(opd1,opd2,opt);
            }
            else if (i%2==1) {
                opt=arr[i];
            }
        }
        return opd1;
    }



    //문자열 실수 변경 메소드
    private float convertToFloat(String opd) {
        try {
            return Float.valueOf(opd);
        }
        catch(Exception e) {
            throw new NumberFormatException("[ERROR]잘못된 숫자를 사용하였습니다.");
        }
    }


    //수식 계산 실행 메소드
    private float subcal(float opd1, float opd2, String opt) {
        return arithmaticExc(opd1,opd2,opt);
    }

    //수식 실행 메소드
    public float arithmaticExc(float opd1, float opd2, String opt) {
        switch (opt){
            case "+":
                return opd1+opd2;
            case "-":
                return opd1-opd2;
            case "*":
                return opd1*opd2;
            case "/":
                return opd1/opd2;
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 연산자를 사용하셨습니다.");
    }

    public void excution() {
        try {
            String[] expArr;
            //문자열 입력받기
            inputString();
            //exit확인
            if (isExit()) return;
            //문자열 배열화
            expArr=splitString();
            //배열의  길이 확인
            isInvalidExp(expArr);
            //계산 실행 및 결과 출력
            System.out.println(calculate(expArr));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}