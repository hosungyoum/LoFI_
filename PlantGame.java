import java.util.Scanner;

class defaultMenu {
	static int money = 10000, size = 0, height = 0;
	String name = "oo";

	int money() {
		return money;
	}

	int size() {
		return size;
	}

	int height() {
		return height;
	}

	String name() {
		return name;
	}

	void defaultMenuprint() {
		System.out.println("������: " + money + "  " + name + "�� ũ��: " + size() + "  " + name + "�� Ű: " + height() + "cm");
	}

	int leftmoney(int p) {
		money = money - p;
		return money;
	}
};

public class Game {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int money;
		int size = 3;
		int height;
		int dday;
		int pot;
		int base = (size * 4);
		int i = size;
		int k = 0;

		String s1 = "?"; // ȭ�� ��� 1
		String s2 = "$";
		String blank = " ";// ȭ�� ���鶧 ���� ����

		defaultMenu d = new defaultMenu();
		d.defaultMenuprint();
		// ȭ�� ���� �κ�
		// ȭ�� ������ potprice��� �������� ���
		int potprice = 5000; // �����Դϴ�.
		d.leftmoney(potprice);
		d.defaultMenuprint();

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

