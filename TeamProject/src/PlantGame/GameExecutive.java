package PlantGame;

ipackage PlantGame;

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

		// --------------------------------------

		Fertilizer f = new Fertilizer();
		f.FertilizerChoose();
		int FertilizerNumber = sc.nextInt();
		int FertilizerPrice = 0;
		while (FertilizerNumber != 1 && FertilizerNumber != 2 && FertilizerNumber != 3 && FertilizerNumber != 4) {
			System.out.println("�Ĺ��� Ű��� ���ؼ��� ���� �ʼ�!!" + "\n �ٽ� �Է����ּ���.");
			FertilizerNumber = sc.nextInt();
		}
		switch (FertilizerNumber) {
		case 1:
			StarFertilizer sf = new StarFertilizer();
			System.out.println("�� ��Ḧ �����ϼ̱���!!");
			FertilizerPrice = sf.FertilizerPrice();
			break;
		case 2:
			AtFertilizer af = new AtFertilizer();
			System.out.println("����� ��Ḧ �����ϼ̱���!!");
			FertilizerPrice = af.FertilizerPrice();
			break;
		case 3:
			ShopFertilizer s2f = new ShopFertilizer();
			System.out.println("�칰 ��Ḧ �����ϼ̱���!!");
			FertilizerPrice = s2f.FertilizerPrice();
			break;
		case 4:
			AddFertilizer a2f = new AddFertilizer();
			System.out.println("���ϱ� ��Ḧ �����ϼ̱���!!");
			FertilizerPrice = a2f.FertilizerPrice();
			break;
		}

		d.leftmoney(FertilizerPrice);
		d.defaultMenuprint();
		d.endCondition1();

		// ---------------------------------------------------------

		System.out.println(" ---------------------------------- ");

		Seed c = new Seed();
		c.SeedChoose();
		int SeedNumber = sc.nextInt();
		int SeedPrice = 0;
		String Seed = " ";
		while (SeedNumber != 1 && SeedNumber != 2 && SeedNumber != 3 && SeedNumber != 4) {
			System.out.println("���ϴ� �Ĺ��� ������ �����غ���!" + "\n �ٽ� �Է����ּ���.");
			SeedNumber = sc.nextInt();
		}
		switch (SeedNumber) {
		case 1:
			StarSeed sf = new StarSeed();
			System.out.println("�� ��Ḧ �����ϼ̱���!!");
			Seed = sf.Seed;
			SeedPrice = sf.SeedPrice();
			break;
		case 2:
			AtSeed af = new AtSeed();
			System.out.println("����� ��Ḧ �����ϼ̱���!!");
			Seed = af.Seed;
			SeedPrice = af.SeedPrice();
			break;
		case 3:
			ShopSeed s2f = new ShopSeed();
			System.out.println("�칰 ��Ḧ �����ϼ̱���!!");
			Seed = s2f.Seed;
			SeedPrice = s2f.SeedPrice();
			break;
		case 4:
			AddSeed a2f = new AddSeed();
			System.out.println("���ϱ� ��Ḧ �����ϼ̱���!!");
			Seed = a2f.Seed;
			SeedPrice = a2f.SeedPrice();
			break;
		}

		d.leftmoney(SeedPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// ���ѱ���
		Naming naming = new Naming();
		naming.namePrint();
		d.name = sc.next();
		d.defaultMenuprint();
		System.out.println(" ---------------------------------- ");

		MiniGame m = new MiniGame();
		m.GameChoose();
		int GameNumber = sc.nextInt();
		int bouns = 0;
		String selectgame = " ";
		while (GameNumber != 1 && GameNumber != 2) {
			System.out.println("�Ĺ� ������ ���� ���� �������!!!!" + "\n ������ �ٽ� �������ּ���!");
			GameNumber = sc.nextInt();
		}
		switch (GameNumber) {
		case 1:
			flowername g1 = new flowername();
			System.out.println("�Ĺ��̸� ���߱� ������ �����ϼ̱���!!");
			selectgame = g1.selectgame;
			flowername firstgame = new flowername();
			firstgame.floriography();
			firstgame.count = bouns;
			System.out.println(bouns);

			break;
		case 2:
			Drawing g2 = new Drawing();
			System.out.println("���� ���߱⸦ �����ϼ̱���!!");
			selectgame = g2.selectgame;
			Drawing secondgame = new Drawing();
			secondgame.DrawingGame();

			break;
		}
		d.leftmoney(bouns);
		d.defaultMenuprint();
		d.endCondition1();
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
		if (money == 0) {
			System.out.println("���� �����մϴ�!!");
		} else if (money < 0) {
			System.out.println("�Ĺ��� �� �̻� Ű�� ���� �����!! �̴ϰ����� �����ϼ���!!");
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

class Seed {
	void SeedChoose() {
		System.out.println();
		System.out.println(
				"## �� �����ϱ� ##" + "\n[1] *�� ����(W1000) [2] @����� ����(W2000)  [3] #�칰 ����(W3000)  [4] +���ϱ� ����(W4000)");
		System.out.println();
		System.out.println("## ������ �������ּ���:) ##  (�ش� ������ ���ڸ� �Է��ϼ���.)");
	}

	int SeedPrice() {
		return 0;
	}

	String Seed = " ";
}

class StarSeed extends Seed {
	int SeedPrice() {
		return 1000;
	}

	String Seed = "*";

};

class AtSeed extends Seed {
	int SeedPrice() {
		return 2000;
	}

	String Seed = "@";
};

class ShopSeed extends Seed {
	int SeedPrice() {
		return 3000;
	}

	String Seed = "#";
};

class AddSeed extends Seed {
	int SeedPrice() {
		return 4000;
	}

	String Seed = "+";
};

class Naming {
	void namePrint() {
		System.out.println();
		System.out.println("## �̸� ���� ##");
		System.out.print("�̸��� �Է����ּ��� : ");
	}
};

class MiniGame {

	void GameChoose() {
		System.out.println();
		System.out.println("## �̴ϰ��� �����ϱ� ##" + "\n[1] �ɸ��̸� ���߱�!! [2] ���� ���� ���߱�!!");
	}

	public void flowername() {
		// TODO Auto-generated method stub

	}

	public void DrawingGame() {

	}

	String selectgame = " ";

};

class flowername extends MiniGame {

	public int count;

	void NameGame() {

		System.out.println("�غ� �Ǽ����� EnterŰ�� ��������");
		Scanner scan = new Scanner(System.in);
		String enter = " ";
		enter = scan.nextLine();

		System.out.println("3�� �ڿ� �����մϴ�");
		try {
			for (int i = 3; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ----------------------------------------------
		System.out.println("�����ϰڽ��ϴ�");
		Scanner scan1 = new Scanner(System.in);
		String enter1 = " ";
		enter1 = scan1.nextLine();

		System.out.println("3�� �ڿ� �����մϴ�");

		try {
			for (int i = 3; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		floriography();
	}

	// ------------------------------------------------

	void floriography() {

		System.out.println("������  ���, ����� ����, �״븦 �������ٰ� ����մϴ��� �ɸ��� ���� ���� �����ϱ��?");
		Scanner scan1 = new Scanner(System.in);
		String enter1 = " ";
		enter1 = scan1.nextLine();
		boolean b = enter1.contains("����");
		if (b == true) {
			System.out.println("�����Դϴ�!");
			count++;
		} else {
			System.out.println("Ʋ�Ƚ��ϴ�. ������ " + '"' + "����" + '"' + "�Դϴ�");
		}
		// =============================================================================
		System.out.println("����, ����, ����� ���ϴ� ����?");
		Scanner scan2 = new Scanner(System.in);
		String enter2 = " ";
		enter2 = scan1.nextLine();
		boolean b1 = enter2.contains("���");
		if (b1 == true) {
			System.out.println("�����Դϴ�!");
			count++;
		} else {
			System.out.println("Ʋ�Ƚ��ϴ�. ������ " + '"' + "���" + '"' + "�Դϴ�");
		}
		//
		System.out.println("¦���, ���, ����� ���ϴ� ����?");
		Scanner scan3 = new Scanner(System.in);
		String enter3 = " ";
		enter3 = scan1.nextLine();
		boolean b2 = enter3.contains("�عٶ��");
		if (b2 == true) {
			System.out.println("�����Դϴ�!");
			count++;
		} else {
			System.out.println("Ʋ�Ƚ��ϴ�. ������ " + '"' + "�عٶ��" + '"' + "�Դϴ�");
		}
		// -----------------------------------------------------------------------
		System.out.println("�����ǳ��� �ִ� ���� �����ϱ��?");
		Scanner scan4 = new Scanner(System.in);
		String enter4 = " ";
		enter4 = scan4.nextLine();
		boolean b3 = enter4.contains("ī���̼�");
		if (b3 == true) {
			System.out.println("�����Դϴ�!");
			count++;
		} else {
			System.out.println("Ʋ�Ƚ��ϴ�. ������ " + '"' + "ī���̼�" + '"' + "�Դϴ�");
		}

		System.out.println("���� ������ " + count + "�� �Դϴ�");
		System.out.println("����� " + count * 1000);
		count = count * 1000;
	}
};

class Drawing extends MiniGame {

	int Com[] = new int[3]; // �������� ������ �� 3����
	int User[] = new int[3]; // ����ڰ� ���ߴ� 3���� ����� ��
	int num = 0;
	int count = 0;
	boolean loop = true;

	int bingo = 0; // �����
	int failure = 0; // ������ ��

	public void DrawingGame() {
		for (int i = 0; i < Com.length; i++) {
			Com[i] = (int) (Math.random() * 9) + 1;
			for (int j = 0; j < i; j++) {
				if (Com[j] == Com[i]) {
					i--;
					break;
				}
			}
		}
		// ----------------------------------------

		Scanner sc = new Scanner(System.in);
		System.out.println("1 ~ 3�� ������ �Է��ϼ���!!");

		loop = true;
		while (loop) {
			for (int i = 0; i < User.length; i++) {
				num = sc.nextInt();
				User[i] = num;
				if (num < 0 || num > 4) {
					System.out.println("1~3�� ������ �Է��ϼ���");
				}
			}

			for (int i = 0; i < Com.length; i++) {
				for (int j = 0; j < User.length; j++) {
					if (Com[i] == User[j] && i == j) {
						bingo++;
					} else if (Com[i] == User[j] && i != j) {
						failure++;
					}
				}
			}

			System.out.println(bingo + "����" + failure + "����");
			bingo = 0;
			failure = 0;

			if (bingo >= 3) {
				loop = false;
			}
			count = count + 1;
		}

		System.out.println("Ƚ�� : " + (count - 1));
		System.out.println("�̴ϰ��� ��!!");
		sc.close();
	}
};