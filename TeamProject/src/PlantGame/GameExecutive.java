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

		// --------------------------------------

		Fertilizer f = new Fertilizer();
		f.FertilizerChoose();
		int FertilizerNumber = sc.nextInt();
		int FertilizerPrice = 0;
		while (FertilizerNumber != 1 && FertilizerNumber != 2 && FertilizerNumber != 3 && FertilizerNumber != 4) {
			System.out.println("식물을 키우기 위해서는 비료는 필수!!" + "\n 다시 입력해주세요.");
			FertilizerNumber = sc.nextInt();
		}
		switch (FertilizerNumber) {
		case 1:
			StarFertilizer sf = new StarFertilizer();
			System.out.println("별 비료를 선택하셨군요!!");
			FertilizerPrice = sf.FertilizerPrice();
			break;
		case 2:
			AtFertilizer af = new AtFertilizer();
			System.out.println("골뱅이 비료를 선택하셨군요!!");
			FertilizerPrice = af.FertilizerPrice();
			break;
		case 3:
			ShopFertilizer s2f = new ShopFertilizer();
			System.out.println("우물 비료를 선택하셨군요!!");
			FertilizerPrice = s2f.FertilizerPrice();
			break;
		case 4:
			AddFertilizer a2f = new AddFertilizer();
			System.out.println("더하기 비료를 선택하셨군요!!");
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
			System.out.println("원하는 식물의 씨앗을 선택해봐요!" + "\n 다시 입력해주세요.");
			SeedNumber = sc.nextInt();
		}
		switch (SeedNumber) {
		case 1:
			StarSeed sf = new StarSeed();
			System.out.println("별 비료를 선택하셨군요!!");
			Seed = sf.Seed;
			SeedPrice = sf.SeedPrice();
			break;
		case 2:
			AtSeed af = new AtSeed();
			System.out.println("골뱅이 비료를 선택하셨군요!!");
			Seed = af.Seed;
			SeedPrice = af.SeedPrice();
			break;
		case 3:
			ShopSeed s2f = new ShopSeed();
			System.out.println("우물 비료를 선택하셨군요!!");
			Seed = s2f.Seed;
			SeedPrice = s2f.SeedPrice();
			break;
		case 4:
			AddSeed a2f = new AddSeed();
			System.out.println("더하기 비료를 선택하셨군요!!");
			Seed = a2f.Seed;
			SeedPrice = a2f.SeedPrice();
			break;
		}

		d.leftmoney(SeedPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// 씨앗구현
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
			System.out.println("식물 성장을 위해 돈을 벌어봐요!!!!" + "\n 게임을 다시 선택해주세요!");
			GameNumber = sc.nextInt();
		}
		switch (GameNumber) {
		case 1:
			flowername g1 = new flowername();
			System.out.println("식물이름 맞추기 게임을 선택하셨군요!!");
			selectgame = g1.selectgame;
			flowername firstgame = new flowername();
			firstgame.floriography();
			firstgame.count = bouns;
			System.out.println(bouns);

			break;
		case 2:
			Drawing g2 = new Drawing();
			System.out.println("숫자 맞추기를 선택하셨군요!!");
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
		System.out.println("가진돈: " + money + "  " + name + "의 크기: " + size() + "  " + name + "의 키: " + height() + "cm");
	}

	int leftmoney(int p) {
		money = money - p;
		return money;
	}

	void endCondition1() {
		if (money == 0) {
			System.out.println("돈이 부족합니다!!");
		} else if (money < 0) {
			System.out.println("식물을 더 이상 키울 수가 없어요!! 미니게임을 진행하세요!!");
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

class Seed {
	void SeedChoose() {
		System.out.println();
		System.out.println(
				"## 씨 선택하기 ##" + "\n[1] *별 씨앗(W1000) [2] @골뱅이 씨앗(W2000)  [3] #우물 씨앗(W3000)  [4] +더하기 씨앗(W4000)");
		System.out.println();
		System.out.println("## 씨앗을 선택해주세요:) ##  (해당 씨앗의 숫자를 입력하세요.)");
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
		System.out.println("## 이름 짓기 ##");
		System.out.print("이름을 입력해주세요 : ");
	}
};

class MiniGame {

	void GameChoose() {
		System.out.println();
		System.out.println("## 미니게임 선택하기 ##" + "\n[1] 꽃말이름 맞추기!! [2] 랜덤 숫자 맞추기!!");
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

		System.out.println("준비가 되셨으면 Enter키를 누르세요");
		Scanner scan = new Scanner(System.in);
		String enter = " ";
		enter = scan.nextLine();

		System.out.println("3초 뒤에 시작합니다");
		try {
			for (int i = 3; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ----------------------------------------------
		System.out.println("시작하겠습니다");
		Scanner scan1 = new Scanner(System.in);
		String enter1 = " ";
		enter1 = scan1.nextLine();

		System.out.println("3초 뒤에 시작합니다");

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

		System.out.println("진실한  사랑, 겸손한 마음, 그대를 누구보다고 사랑합니다의 꽃말을 가진 꽃은 무엇일까요?");
		Scanner scan1 = new Scanner(System.in);
		String enter1 = " ";
		enter1 = scan1.nextLine();
		boolean b = enter1.contains("동백");
		if (b == true) {
			System.out.println("정답입니다!");
			count++;
		} else {
			System.out.println("틀렸습니다. 정답은 " + '"' + "동백" + '"' + "입니다");
		}
		// =============================================================================
		System.out.println("열정, 정열, 사랑을 뜻하는 꽃은?");
		Scanner scan2 = new Scanner(System.in);
		String enter2 = " ";
		enter2 = scan1.nextLine();
		boolean b1 = enter2.contains("장미");
		if (b1 == true) {
			System.out.println("정답입니다!");
			count++;
		} else {
			System.out.println("틀렸습니다. 정답은 " + '"' + "장미" + '"' + "입니다");
		}
		//
		System.out.println("짝사랑, 흠모, 헌신을 뜻하는 꽃은?");
		Scanner scan3 = new Scanner(System.in);
		String enter3 = " ";
		enter3 = scan1.nextLine();
		boolean b2 = enter3.contains("해바라기");
		if (b2 == true) {
			System.out.println("정답입니다!");
			count++;
		} else {
			System.out.println("틀렸습니다. 정답은 " + '"' + "해바라기" + '"' + "입니다");
		}
		// -----------------------------------------------------------------------
		System.out.println("스승의날에 주는 꽃은 무엇일까요?");
		Scanner scan4 = new Scanner(System.in);
		String enter4 = " ";
		enter4 = scan4.nextLine();
		boolean b3 = enter4.contains("카네이션");
		if (b3 == true) {
			System.out.println("정답입니다!");
			count++;
		} else {
			System.out.println("틀렸습니다. 정답은 " + '"' + "카네이션" + '"' + "입니다");
		}

		System.out.println("맞힌 개수는 " + count + "개 입니다");
		System.out.println("상금은 " + count * 1000);
		count = count * 1000;
	}
};

class Drawing extends MiniGame {

	int Com[] = new int[3]; // 랜덤으로 나오는 수 3가지
	int User[] = new int[3]; // 사용자가 맞추는 3가지 경우의 수
	int num = 0;
	int count = 0;
	boolean loop = true;

	int bingo = 0; // 정답수
	int failure = 0; // 실패한 수

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
		System.out.println("1 ~ 3의 정수를 입력하세요!!");

		loop = true;
		while (loop) {
			for (int i = 0; i < User.length; i++) {
				num = sc.nextInt();
				User[i] = num;
				if (num < 0 || num > 4) {
					System.out.println("1~3의 정수를 입력하세요");
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

			System.out.println(bingo + "성공" + failure + "실패");
			bingo = 0;
			failure = 0;

			if (bingo >= 3) {
				loop = false;
			}
			count = count + 1;
		}

		System.out.println("횟수 : " + (count - 1));
		System.out.println("미니게임 끝!!");
		sc.close();
	}
};