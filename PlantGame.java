import java.util.Scanner; 

public class plant {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int money;
        int size;
        int height;
        int dday;
        int pot;

        System.out.print("## ȭ�� �����ϱ� ##" + "\n[1] ? ȭ�� [2] $ ȭ��" + "\n## ȭ�и� �������ּ���:) ");
        pot = scan.nextInt();

        switch (pot) {
        case 1:
            System.out.print("��ȭ�� ? ȭ���������ϼ̱���!!");
            break;
        case 2:
            System.out.print("ȭ���� $ ȭ���� �����ϼ̱���!!");
            break;
        default:
            System.out.print("�Ĺ��� Ű��� ���ؼ��� ȭ���� �ʼ�!!");
        }


    }
}

