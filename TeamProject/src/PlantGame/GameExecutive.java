package PlantGame;

import java.util.Scanner;

public class GameExecutive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		defaultMenu d = new defaultMenu();
		System.out.println("�ȳ��ϼ���! �Ĺ� Ű��� �������� ���� �غ���~ :)");
		// �̸�����
		System.out.println("�켱 ����� �Ĺ��� �̸��� �����ּ���~");
		Naming naming = new Naming();
		naming.namePrint();
		d.name = sc.next();
		System.out.println();
		System.out.println("�����մϴ�! ��ſ��� Ȩ����� ������ 10000���� �־������ϴ�!");
		System.out.println("���ݺ��� " + d.name + "��(��) �� Ű�����ƿ�!");
		d.defaultMenuprint();
		// ȭ�� ����
		Pot p = new Pot();
		p.PotChoose();
		int nationNumber = sc.nextInt();
		int potPrice = 0;
		String nation = " ";
		while (nationNumber != 1 && nationNumber != 2) {
			System.out.println("�Ĺ��� Ű��� ���ؼ��� ȭ���� �ʼ�!!" + "\n�ٽ� �Է����ּ���.");
			nationNumber = sc.nextInt();
		}
		switch (nationNumber) {
		case 1:
			KorPot kp = new KorPot();
			System.out.println("�ѱ� ȭ���� �����ϼ̱���!!");
			nation = kp.nation;
			p.PotPrint(nation, 10);
			potPrice = kp.potPrice();
			break;
		case 2:
			EngPot ep = new EngPot();
			System.out.println("�̱� ȭ���� �����ϼ̱���!!");
			nation = ep.nation;
			p.PotPrint(nation, 10);
			potPrice = ep.potPrice();
			break;
		}
		d.leftmoney(potPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// ��� ����
		Fertilizer f = new Fertilizer();
		f.FertilizerChoose();
		int FertilizerNumber = sc.nextInt();
		int FertilizerPrice = 0;
		String Fertilizer = " ";
		while (FertilizerNumber != 1 && FertilizerNumber != 2 && FertilizerNumber != 3 && FertilizerNumber != 4) {
			System.out.println("�Ĺ��� Ű��� ���ؼ��� ���� �ʼ�!!" + "\n�ٽ� �Է����ּ���.");
			FertilizerNumber = sc.nextInt();
		}
		switch (FertilizerNumber) {
		case 1:
			StarFertilizer sf = new StarFertilizer();
			System.out.println("* �� ��Ḧ �����ϼ̱���!!");
			Fertilizer = sf.Fertilizer;
			FertilizerPrice = sf.FertilizerPrice();
			break;
		case 2:
			AtFertilizer af = new AtFertilizer();
			System.out.println("@ ����� ��Ḧ �����ϼ̱���!!");
			Fertilizer = af.Fertilizer;
			FertilizerPrice = af.FertilizerPrice();
			break;
		case 3:
			ShopFertilizer s2f = new ShopFertilizer();
			System.out.println("# �칰 ��Ḧ �����ϼ̱���!!");
			Fertilizer = s2f.Fertilizer;
			FertilizerPrice = s2f.FertilizerPrice();
			break;
		case 4:
			AddFertilizer a2f = new AddFertilizer();
			System.out.println("+ ���ϱ� ��Ḧ �����ϼ̱���!!");
			Fertilizer = a2f.Fertilizer;
			FertilizerPrice = a2f.FertilizerPrice();
			break;
		}
		d.leftmoney(FertilizerPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// ���� ����
		Seed s = new Seed();
		s.SeedChoose();
		int SeedNumber = sc.nextInt();
		int SeedPrice = 0;
		while (SeedNumber != 1 && SeedNumber != 2 && SeedNumber != 3) {
			System.out.println("���ϴ� �Ĺ��� ������ �����غ���!" + "\n�ٽ� �Է����ּ���.");
			SeedNumber = sc.nextInt();
		}
		switch (SeedNumber) {
		case 1:
			triangleSeed ts = new triangleSeed();
			System.out.println("����ɾ����� �����ϼ̱���!!");
			SeedPrice = ts.SeedPrice();
			break;
		case 2:
			squareSeed sqs = new squareSeed();
			System.out.println("�׸�ɾ����� �����ϼ̱���!!");
			SeedPrice = sqs.SeedPrice();
			break;
		case 3:
			diamondSeed ds = new diamondSeed();
			System.out.println("���̾Ƹ��ɾ����� �����ϼ̱���!!");
			SeedPrice = ds.SeedPrice();
			break;
		}
		d.leftmoney(SeedPrice);
		d.defaultMenuprint();
		d.endCondition2();

		// �ɸ� ���߱� ����
		flowernameGame fng = new flowernameGame();
		fng.NameGameStart();
		String[] answer = { "����", "���", "�عٶ��", "ī���̼�", "ƫ��" };
		String[] array = new String[5];
		for (int i = 0; i < 5; i++) {
			fng.floriographyQ(i);
			array[i] = sc.next();
			boolean b = array[i].contains(answer[i]);
			if (b == true) {
				System.out.println("�����Դϴ�!");
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�. ������ " + "\"" + answer[i] + "\"" + "�Դϴ�");
			}
		}
		int countWin = fng.correctAnswer(array);
		fng.correctAnswerPrint(countWin);
		d.size = fng.flowerSize();
		d.defaultMenuprint();

		// ���淯���� ����
		waterGame wg = new waterGame();
		wg.waterGameStart();
		System.out.println();
		System.out.println("������ �� 10ȸ ���� �˴ϴ�!" + "\n���ӿ� �����ϸ� +500ml ���� �־����ϴ�");
		int[] com = new int[10];
		int[] user = new int[10];
		com = wg.comRandom(com);
		for (int i = 0; i < user.length; i++) {
			System.out.println();
			System.out.println(i + 1 + ". 1~3�� ������ �Է��ϼ���!");
			user[i] = sc.nextInt();
			while (user[i] != 1 && user[i] != 2 && user[i] != 3) {
				System.out.println("1~3�� ������ �Է����� �ʾҽ��ϴ�. �ٽ� �ѹ� �Է��� �ּ���.");
				user[i] = sc.nextInt();
			}
			if (user[i] == com[i]) {
				wg.bingo++;
				System.out.println("���������� ���� �淯���µ� �����߽��ϴ�!");
				System.out.println("���� ���� " + wg.water() + "ml �ֽ��ϴ�!");
			} else {
				System.out.println("���θ��� �Ѿ����� ���� ���������ϴ�!!");
				System.out.println("���� ���� " + wg.water() + "ml �ֽ��ϴ�!");
			}
		}
		wg.waterPrint();
		d.height = wg.watergrow();
		d.defaultMenuprint();

		// �ܵ� ����
		change cm = new change();
		System.out.println("���� �ִ� ���� ��� ���� �� �� �����ϴ�." + "\n�ٷ� �Ĺ��� �����ŵ�ϴ�!");
		cm.changePrint(d.money);
		int yesOrNo = sc.nextInt();
		while (yesOrNo != 1 && yesOrNo != 2) {
			System.out.println("�ش� ���ڸ� �Է����ּ���!" + "\n�ٽ� �Է����ּ���.");
			yesOrNo = sc.nextInt();
		}
		switch (yesOrNo) {
		case 1:
			if (d.money == 0) {
				System.out.println("���� �ִ� ���� ��� ���� �� �� �����ϴ�." + "\n�ٷ� �Ĺ��� �����ŵ�ϴ�!");
				break;
			}
			cm.changePrint2();
			int sizeOrHeight = sc.nextInt();
			while (sizeOrHeight != 1 && sizeOrHeight != 2) {
				System.out.println("�ش� ���ڸ� �Է����ּ���!" + "\n�ٽ� �Է����ּ���.");
				sizeOrHeight = sc.nextInt();
			}
			switch (sizeOrHeight) {
			case 1:
				cm.howMuchPrint(cm.Sizeup);
				int su = sc.nextInt();
				while (cm.moneyToup(d.money, su) < 0) {
					System.out.println("���� �����մϴ�!" + "\n���� ���� Ȯ���ϰ� �ٽ� �Է����ּ���");
					su = sc.nextInt();
				}
				if (cm.moneyToup(d.money, su) == 0) {
					System.out.println("���� ��� ����߽��ϴ�!" + "\n�Ĺ��� �����ŵ�ϴ�!");
					d.size = d.size + su;
					d.money = cm.moneyToup(d.money, su);
				} else {
					d.size = d.size + su;
					d.money = cm.moneyToup(d.money, su);
					cm.changePrint3(d.money, cm.Heightup);
					int yesOrNo2 = sc.nextInt();
					while (yesOrNo != 1 && yesOrNo != 2) {
						System.out.println("�ش� ���ڸ� �Է����ּ���!" + "\n�ٽ� �Է����ּ���.");
						yesOrNo2 = sc.nextInt();
					}
					switch (yesOrNo2) {
					case 1:
						cm.howMuchPrint(cm.Heightup);
						int hu = sc.nextInt();
						while (cm.moneyToup(d.money, hu) < 0) {
							System.out.println("���� �����մϴ�!" + "\n���� ���� Ȯ���ϰ� �ٽ� �Է����ּ���");
							hu = sc.nextInt();
						}
						d.height = d.height + hu;
						d.money = cm.moneyToup(d.money, hu);
						System.out.println("�ٷ� �Ĺ��� �����ŵ�ϴ�!");
						break;
					case 2:
						System.out.println("�ٷ� �Ĺ��� �����ŵ�ϴ�!");
						break;
					}
				}
				break;
			case 2:
				cm.howMuchPrint(cm.Heightup);
				int hu = sc.nextInt();
				while (cm.moneyToup(d.money, hu) < 0) {
					System.out.println("���� �����մϴ�!" + "\n���� ���� Ȯ���ϰ� �ٽ� �Է����ּ���");
					hu = sc.nextInt();
				}
				if (cm.moneyToup(d.money, hu) == 0) {
					System.out.println("���� ��� ����߽��ϴ�!" + "\n�Ĺ��� �����ŵ�ϴ�!");
					d.height = d.height + hu;
					d.money = cm.moneyToup(d.money, hu);
				} else {
					d.money = cm.moneyToup(d.money, hu);
					cm.changePrint3(d.money, cm.Sizeup);
					int yesOrNo2 = sc.nextInt();
					while (yesOrNo != 1 && yesOrNo != 2) {
						System.out.println("�ش� ���ڸ� �Է����ּ���!" + "\n�ٽ� �Է����ּ���.");
						yesOrNo2 = sc.nextInt();
					}
					switch (yesOrNo2) {
					case 1:
						cm.howMuchPrint(cm.Sizeup);
						su = sc.nextInt();
						while (cm.moneyToup(d.money, su) < 0) {
							System.out.println("���� �����մϴ�!" + "\n���� ���� Ȯ���ϰ� �ٽ� �Է����ּ���");
							su = sc.nextInt();
						}
						d.size = d.size + su;
						d.money = cm.moneyToup(d.money, su);
						System.out.println("�ٷ� �Ĺ��� �����ŵ�ϴ�!");
						break;
					case 2:
						System.out.println("�ٷ� �Ĺ��� �����ŵ�ϴ�!");
						break;
					}
				}
				break;
			}
			break;
		case 2:
			System.out.println("�ܵ����̸� ���� �ʰ� �ٷ� �Ĺ��� ������׽��ϴ�!");
			break;
		}
		d.defaultMenuprint();

		// ���
		finalPrint perfect = new finalPrint();
		perfect.finalPrintStart();
		perfect.pefectSeedPrint(SeedNumber, d.size, Fertilizer);
		Stem stem = new Stem();
		int middle = stem.middle(d.size);
		stem.Stemprint(middle, d.height);
		p.PotPrint(nation, d.size);
		p.potUnder(d.size, d.name);
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
		System.out.println("--------------------------------------------------------------------------");
		System.out.println(
				"������: " + money + "  " + name + "(��)�� ũ��: " + size() + "  " + name + "�� Ű: " + height() + "cm");
		System.out.println("--------------------------------------------------------------------------");
	}

	int leftmoney(int p) {
		this.money = money - p;
		return money;
	}

	void endCondition1() {
		if (money <= 0) {
			System.out.println("���� �� ������� ���̻� �Ĺ��� Ű�� �� �����ϴ�!");
			System.out.println("�� �������ּ���!");
			System.exit(0);
		}
	}

	void endCondition2() {
		if (money < 0) {
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
		System.out.println("ȭ�и� �������ּ���:)  (�ش� ȭ���� ���ڸ� �Է��ϼ���.)");
	}

	String nation = " ";

	void PotPrint(String s, int potsize) {
		int line = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (5 - line) * 2 + (potsize + 4); k++) {
				System.out.print(s);
			}
			System.out.println();
			line += 1;
		}

	}

	void potUnder(int size, String name) {
		for (int i = 0; i < size; i++) {
			System.out.print("-");
		}
		System.out.print(name);
		for (int i = 0; i < size; i++) {
			System.out.print("-");
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
		System.out.println("��Ḧ �������ּ���:)   (�ش� ����� ���ڸ� �Է��ϼ���.)");
	}

	int FertilizerPrice() {
		return 0;
	}

	String Fertilizer = " ";
};

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

//------------------------------------------------------------------
class Seed {
	void SeedChoose() {
		System.out.println();
		System.out.println("## ���� �����ϱ� ##" + "\n[1] ����� ����(W1000) [2] �׸�� ����(W2000)  [3] ���̾Ƹ��� ����(W3000)");
		System.out.println();
		System.out.println("������ �������ּ���:)    (�ش� ������ ���ڸ� �Է��ϼ���.)");
	}

	int SeedPrice() {
		return 0;
	}

	void SeedPrint() {

	}
};

class triangleSeed extends Seed {
	int SeedPrice() {
		return 1000;
	}

	void SeedPrint(int size, String c) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (i * 2 + 1); k++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

};

class squareSeed extends Seed {
	int SeedPrice() {
		return 2000;
	}

	void SeedPrint(int size, String c) {
		for (int i = 1; i <= size; i++) {
			for (int k = 0; k < size / 2; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= size; j++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
};

class diamondSeed extends Seed {
	int SeedPrice() {
		return 3000;
	}

	void SeedPrint(int size, String c) {
		int m = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < (size - m); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (m * 2) - 1; k++) {
				System.out.print(c);
			}
			System.out.println();
			m += 1;
		}
		int n = 0;
		for (int I = 0; I < size; I++) {
			for (int J = 0; J <= I; J++) {
				System.out.print(" ");
			}
			for (int K = 0; K < (size - n) * 2 - 1; K++) {
				System.out.print(c);
			}
			System.out.println();
			n += 1;
		}

	}
};

class Stem {
	int middle(int size) {
		return size - 1;
	}

	void Stemprint(int middle, int h) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < middle; j++) {
				System.out.print(" ");
			}
			System.out.println("||");
		}
	}
};

class flowernameGame {
	int countWin = 0;

	void NameGameStart() {
		System.out.println("���ݺ��� �Ĺ��� ���� �������� �׽�Ʈ �ϱ����� �ɸ� ���� ���߱������ �����ϰڽ��ϴ�!");
		System.out.println("�� ������ �������� �������� �Ĺ��� ũ�Ⱑ �����˴ϴ�! ");
		System.out.println("5�� �ڿ� �����մϴ�");
		try {
			for (int i = 5; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("GAME START!");
	}

	void floriographyQ(int i) {
		switch (i) {
		case 0:
			System.out.println(i + 1 + ". ������  ���, ����� ����, �״븦 �������ٰ� ����մϴ��� �ɸ��� ���� ���� �����ϱ��?");
			break;
		case 1:
			System.out.println(i + 1 + ". ����, ����, ����� ���ϸ� ���� ������������� �ִ� ����?");
			break;
		case 2:
			System.out.println(i + 1 + ". ¦���, ���, ����� ���ϴ� ����?    hint:sun");
			break;
		case 3:
			System.out.println(i + 1 + ". ����, ���, ������ ������ ���ϸ� ����̳��� ������ ���� �ִ� ����?");
			break;
		case 4:
			System.out.println(i + 1 + ". �״������� ��¡�̸� ����� ���,��Ȥ,������ ����,����� ���ϴ� ����?");
			break;
		}
	}

	int correctAnswer(String[] array) {
		String[] answer = { "����", "���", "�عٶ��", "ī���̼�", "ƫ��" };
		for (int i = 0; i < 5; i++) {
			boolean b1 = array[i].contains(answer[i]);
			if (b1 == true) {
				countWin++;
			}
		}
		return countWin;
	}

	int flowerSize() {
		return countWin * 2;
	}

	void correctAnswerPrint(int n) {
		System.out.println();
		System.out.println("���� ������ ��" + n + "�� �Դϴ�");
	}

};

class waterGame {
	int bingo = 0;

	void waterGameStart() {
		System.out.println("�������� ���淯���� ������ �����ϰڽ��ϴ�!");
		System.out.println("�� ������ ���� ���� ml�� ���� �Ĺ��� Ű�� �����˴ϴ�! ");
		System.out.println("5�� �ڿ� �����մϴ�");
		try {
			for (int i = 5; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("GAME START!");
	}

	int[] comRandom(int[] com) {
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 3) + 1;
		}
		return com;
	}

	int water() {
		return bingo * 500;
	}

	int watergrow() {
		return bingo * 2;
	}

	void waterPrint() {
		System.out.println();
		System.out.println("�� ���� " + water() + "ml �淯�Խ��ϴ�.");
		System.out.println("�Ĺ��� Ű�� " + watergrow() + "cm �ڶ��ϴ�!");
	}

};

class change {
	String Sizeup = "�Ĺ� ũ�� Ű���";
	String Heightup = "�Ĺ� Ű Ű���";

	void changePrint(int money) {
		System.out.println();
		System.out.println("���� ����� ���� " + money + "�� �����ֽ��ϴ�!");
		System.out.println("�����ִ� ������ �ܵ����̸� �����Ͻðڽ��ϱ�?");
		System.out.println("[1] �� [2] �ƴϿ�");
		System.out.println("(�ش��ϴ� ���ڸ� �Է��ϼ���.)");
	}

	void changePrint2() {
		System.out.println();
		System.out.println("�����ִ� ������ �ܵ����̸� �����մϴ�");
		System.out.println("[1]" + Sizeup + "\t" + "[2]" + Heightup);
		System.out.println("(�ش��ϴ� ���ڸ� �Է��ϼ���.)");
	}

	void changePrint3(int money, String str) {
		System.out.println("����" + money + "�� ���ҽ��ϴ�");
		System.out.println("���� ������ " + str + "�� ���� �Ͻðڽ��ϱ�?");
		System.out.println("[1] �� [2] �ƴϿ�");
		System.out.println("(�ش��ϴ� ���ڸ� �Է��ϼ���.)");
	}

	void howMuchPrint(String str) {
		System.out.println();
		System.out.println(str + "�� �����ϼ̽��ϴ�! ");
		System.out.println("�󸶸�ŭ Ű��ðڽ��ϱ�? " + "\t" + str + " +1 : 200 ��");
		System.out.println("(Ű��� ���ϴ� ũ�⸦ �Է��ϼ���.)");
	}

	int moneyToup(int money, int size) {
		return money - (200 * size);
	}

};

class finalPrint {
	void finalPrintStart() {
		System.out.println("�Ĺ��� �� �� �ڶ󳳴ϴ�!");
		System.out.println("3�ʸ� ��ٷ� �ּ��� :)");
		try {
			for (int i = 3; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void pefectSeedPrint(int SeedNumber, int size, String nation) {
		switch (SeedNumber) {
		case 1:
			triangleSeed ts = new triangleSeed();
			ts.SeedPrint(size, nation);
			break;
		case 2:
			squareSeed sqs = new squareSeed();
			sqs.SeedPrint(size, nation);
			break;
		case 3:
			diamondSeed ds = new diamondSeed();
			ds.SeedPrint(size, nation);
			break;
		}
	}
};
