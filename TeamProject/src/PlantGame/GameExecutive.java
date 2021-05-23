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
			System.out.println("식물을 키우기 위해서는 화분은 필수!!" + "\n 다시 입력해주세요.");
			nationNumber = sc.nextInt();
		}
		switch (nationNumber) {
		case 1:
			KorPot kp = new KorPot();
			System.out.println("한국 화분을 선택하셨군요!!");
			nation = kp.nation;
			p.PotPrint(nation);
			potPrice = kp.potPrice();
			break;
		case 2:
			EngPot ep = new EngPot();
			System.out.println("미국 화분을 선택하셨군요!!");
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
			System.out.println("식물을 키우기 위해서는 비료는 필수!!" + "\n 다시 입력해주세요.");
			FertilizerNumber = sc.nextInt();
		}
		switch (FertilizerNumber) {
		case 1:
			StarFertilizer sf = new StarFertilizer();
			System.out.println("별 비료를 선택하셨군요!!");
			Fertilizer = sf.Fertilizer;
			FertilizerPrice = sf.FertilizerPrice();
			break;
		case 2:
			AtFertilizer af = new AtFertilizer();
			System.out.println("골뱅이 비료를 선택하셨군요!!");
			Fertilizer = af.Fertilizer;
			FertilizerPrice = af.FertilizerPrice();
			break;
		case 3:
			ShopFertilizer s2f = new ShopFertilizer();
			System.out.println("우물 비료를 선택하셨군요!!");
			Fertilizer = s2f.Fertilizer;
			FertilizerPrice = s2f.FertilizerPrice();
			break;
		case 4:
			AddFertilizer a2f = new AddFertilizer();
			System.out.println("더하기 비료를 선택하셨군요!!");
			Fertilizer = a2f.Fertilizer;
			FertilizerPrice = a2f.FertilizerPrice();
			break;
		}
		d.leftmoney(FertilizerPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// 씨앗구매 아직 구현안함.
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
		System.out.println("가진돈: " + money + "  " + name + "의 크기: " + size() + "  " + name + "의 키: " + height() + "cm");
	}

	int leftmoney(int p) {
		money = money - p;
		return money;
	}

	void endCondition1() {
		if (money <= 0) {
			System.out.println("돈을 다 써버려서 더이상 식물을 키울 수 없습니다!");
			System.out.println("재 실행해주세요!");
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
		System.out.println("## 화분 선택하기 ##" + "\n[1] 한국 화분(W5000) [2] 미국 화분($5 *단, 환율은 달러 당 1200원)");
		System.out.println();
		System.out.println("## 화분를 선택해주세요:) ##  (해당 화분의 숫자를 입력하세요.)");
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
				"## 비료 선택하기 ##" + "\n[1] *별 비료(W1000) [2] @골뱅이 비료(W2000)  [3] #우물 비료(W3000)  [4] +더하기 비료(W4000)");
		System.out.println();
		System.out.println("## 비료를 선택해주세요:) ##  (해당 비료의 숫자를 입력하세요.)");
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
		System.out.println("## 이름 짓기 ##");
		System.out.print("이름을 입력해주세요 : ");
	}
};