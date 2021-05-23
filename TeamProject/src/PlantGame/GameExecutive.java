package PlantGame;

import java.util.Scanner;

public class GameExecutive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		defaultMenu d = new defaultMenu();
		d.defaultMenuprint();
		Pot p = new Pot();
		p.PotChoose();
		int nationNumber = sc.nextInt();
		int potPrice = 0;
		String nation = " ";
		while (nationNumber != 1 && nationNumber != 2) {
			System.out.println("�Ĺ��� Ű��� ���ؼ��� ȭ���� �ʼ�!!" + "\n �ٽ� �Է����ּ���.");
			nationNumber = sc.nextInt();
		}
		switch (nationNumber) {
		case 1:
			KorPot kp = new KorPot();
			System.out.println("�ѱ� ȭ���� �����ϼ̱���!!");
			nation = kp.nation;
			p.PotPrint(nation);
			potPrice = kp.potPrice();
			break;
		case 2:
			EngPot ep = new EngPot();
			System.out.println("�̱� ȭ���� �����ϼ̱���!!");
			nation = ep.nation;
			p.PotPrint(nation);
			potPrice = ep.potPrice();
			break;
		}
		d.leftmoney(potPrice);
		d.defaultMenuprint();
		d.endCondition1();
		Fertilizer f = new Fertilizer();
		f.FertilizerChoose();
		int FertilizerNumber = sc.nextInt();
		int FertilizerPrice = 0;
		String Fertilizer = " ";
		while (FertilizerNumber != 1 && FertilizerNumber != 2 && FertilizerNumber != 3 && FertilizerNumber != 4) {
			System.out.println("�Ĺ��� Ű��� ���ؼ��� ���� �ʼ�!!" + "\n �ٽ� �Է����ּ���.");
			FertilizerNumber = sc.nextInt();
		}
		switch (FertilizerNumber) {
		case 1:
			StarFertilizer sf = new StarFertilizer();
			System.out.println("�� ��Ḧ �����ϼ̱���!!");
			Fertilizer = sf.Fertilizer;
			FertilizerPrice = sf.FertilizerPrice();
			break;
		case 2:
			AtFertilizer af = new AtFertilizer();
			System.out.println("����� ��Ḧ �����ϼ̱���!!");
			Fertilizer = af.Fertilizer;
			FertilizerPrice = af.FertilizerPrice();
			break;
		case 3:
			ShopFertilizer s2f = new ShopFertilizer();
			System.out.println("�칰 ��Ḧ �����ϼ̱���!!");
			Fertilizer = s2f.Fertilizer;
			FertilizerPrice = s2f.FertilizerPrice();
			break;
		case 4:
			AddFertilizer a2f = new AddFertilizer();
			System.out.println("���ϱ� ��Ḧ �����ϼ̱���!!");
			Fertilizer = a2f.Fertilizer;
			FertilizerPrice = a2f.FertilizerPrice();
			break;
		}
		d.leftmoney(FertilizerPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// ���ѱ��� ���� ��������.
		Naming naming = new Naming();
		naming.namePrint();
		d.name = sc.next();
		d.defaultMenuprint();

	}
}

class defaultMenu {
	public int money = 10000, size = 0, height = 0;
	public String name = "oo";

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
		System.out.println();
		System.out.println("������: " + money + "  " + name + "�� ũ��: " + size() + "  " + name + "�� Ű: " + height() + "cm");
	}

	int leftmoney(int p) {
		money = money - p;
		return money;
	}

	void endCondition1() {
		if (money <= 0) {
			System.out.println("���� �� ������� ���̻� �Ĺ��� Ű�� �� �����ϴ�!");
			System.out.println("�� �������ּ���!");
			System.exit(0);
		}
	}

};

class Pot {
	int potPrice() {
		return 0;
	}

	void PotChoose() {
		System.out.println();
		System.out.println("## ȭ�� �����ϱ� ##" + "\n[1] �ѱ� ȭ��(W5000) [2] �̱� ȭ��($5 *��, ȯ���� �޷� �� 1200��)");
		System.out.println();
		System.out.println("## ȭ�и� �������ּ���:) ##  (�ش� ȭ���� ���ڸ� �Է��ϼ���.)");
	}

	String nation = " ";

	void PotPrint(String s) {
		int line = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (5 - line) * 2 + 6; k++) {
				System.out.print(s);
			}
			System.out.println();
			line += 1;
		}

	}
};

class KorPot extends Pot {
	int potPrice() {
		return 5000;
	}

	String nation = "W";
};

class EngPot extends Pot {
	int exchange() {
		return 1200;
	}

	int potPrice() {
		return exchange() * 5;
	}

	String nation = "$";
};

class Fertilizer {
	void FertilizerChoose() {
		System.out.println();
		System.out.println(
				"## ��� �����ϱ� ##" + "\n[1] *�� ���(W1000) [2] @����� ���(W2000)  [3] #�칰 ���(W3000)  [4] +���ϱ� ���(W4000)");
		System.out.println();
		System.out.println("## ��Ḧ �������ּ���:) ##  (�ش� ����� ���ڸ� �Է��ϼ���.)");
	}

	int FertilizerPrice() {
		return 0;
	}

	String Fertilizer = " ";
}

class StarFertilizer extends Fertilizer {
	int FertilizerPrice() {
		return 1000;
	}

	String Fertilizer = "*";
};

class AtFertilizer extends Fertilizer {
	int FertilizerPrice() {
		return 2000;
	}

	String Fertilizer = "@";
};

class ShopFertilizer extends Fertilizer {
	int FertilizerPrice() {
		return 3000;
	}

	String Fertilizer = "#";
};

class AddFertilizer extends Fertilizer {
	int FertilizerPrice() {
		return 4000;
	}

	String Fertilizer = "+";
};

class Naming {
	void namePrint() {
		System.out.println();
		System.out.println("## �̸� ���� ##");
		System.out.print("�̸��� �Է����ּ��� : ");
	}
};