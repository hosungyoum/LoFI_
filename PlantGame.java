import java.util.Scanner; 

public class plant {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int money;
        int size;
        int height;
        int dday;
        int pot;

        System.out.print("## 화분 선택하기 ##" + "\n[1] ? 화분 [2] $ 화분" + "\n## 화분를 선택해주세요:) ");
        pot = scan.nextInt();

        switch (pot) {
        case 1:
            System.out.print("단화한 ? 화분을선택하셨군요!!");
            break;
        case 2:
            System.out.print("화려한 $ 화분을 선택하셨군요!!");
            break;
        default:
            System.out.print("식물을 키우기 위해서는 화분은 필수!!");
        }


    }
}

