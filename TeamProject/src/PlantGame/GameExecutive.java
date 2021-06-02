package PlantGame;

import java.util.Scanner;

public class GameExecutive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		defaultMenu d = new defaultMenu();
		System.out.println("안녕하세요! 식물 키우기 게임으로 힐링 해봐요~ :)");
		// 이름짓기
		System.out.println("우선 당신의 식물의 이름을 지어주세요~");
		Naming naming = new Naming();
		naming.namePrint();
		d.name = sc.next();
		System.out.println();
		System.out.println("축하합니다! 당신에게 홈가드닝 지원금 10000원이 주어졌습니다!");
		System.out.println("지금부터 " + d.name + "을(를) 잘 키워보아요!");
		d.defaultMenuprint();
		// 화분 구매
		Pot p = new Pot();
		p.PotChoose();
		int nationNumber = sc.nextInt();
		int potPrice = 0;
		String nation = " ";
		while (nationNumber != 1 && nationNumber != 2) {
			System.out.println("식물을 키우기 위해서는 화분은 필수!!" + "\n다시 입력해주세요.");
			nationNumber = sc.nextInt();
		}
		switch (nationNumber) {
		case 1:
			KorPot kp = new KorPot();
			System.out.println("한국 화분을 선택하셨군요!!");
			nation = kp.nation;
			p.PotPrint(nation, 10);
			potPrice = kp.potPrice();
			break;
		case 2:
			EngPot ep = new EngPot();
			System.out.println("미국 화분을 선택하셨군요!!");
			nation = ep.nation;
			p.PotPrint(nation, 10);
			potPrice = ep.potPrice();
			break;
		}
		d.leftmoney(potPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// 비료 구매
		Fertilizer f = new Fertilizer();
		f.FertilizerChoose();
		int FertilizerNumber = sc.nextInt();
		int FertilizerPrice = 0;
		String Fertilizer = " ";
		while (FertilizerNumber != 1 && FertilizerNumber != 2 && FertilizerNumber != 3 && FertilizerNumber != 4) {
			System.out.println("식물을 키우기 위해서는 비료는 필수!!" + "\n다시 입력해주세요.");
			FertilizerNumber = sc.nextInt();
		}
		switch (FertilizerNumber) {
		case 1:
			StarFertilizer sf = new StarFertilizer();
			System.out.println("* 별 비료를 선택하셨군요!!");
			Fertilizer = sf.Fertilizer;
			FertilizerPrice = sf.FertilizerPrice();
			break;
		case 2:
			AtFertilizer af = new AtFertilizer();
			System.out.println("@ 골뱅이 비료를 선택하셨군요!!");
			Fertilizer = af.Fertilizer;
			FertilizerPrice = af.FertilizerPrice();
			break;
		case 3:
			ShopFertilizer s2f = new ShopFertilizer();
			System.out.println("# 우물 비료를 선택하셨군요!!");
			Fertilizer = s2f.Fertilizer;
			FertilizerPrice = s2f.FertilizerPrice();
			break;
		case 4:
			AddFertilizer a2f = new AddFertilizer();
			System.out.println("+ 더하기 비료를 선택하셨군요!!");
			Fertilizer = a2f.Fertilizer;
			FertilizerPrice = a2f.FertilizerPrice();
			break;
		}
		d.leftmoney(FertilizerPrice);
		d.defaultMenuprint();
		d.endCondition1();
		// 씨앗 구매
		Seed s = new Seed();
		s.SeedChoose();
		int SeedNumber = sc.nextInt();
		int SeedPrice = 0;
		while (SeedNumber != 1 && SeedNumber != 2 && SeedNumber != 3) {
			System.out.println("원하는 식물의 씨앗을 선택해봐요!" + "\n다시 입력해주세요.");
			SeedNumber = sc.nextInt();
		}
		switch (SeedNumber) {
		case 1:
			triangleSeed ts = new triangleSeed();
			System.out.println("세모꽃씨앗을 선택하셨군요!!");
			SeedPrice = ts.SeedPrice();
			break;
		case 2:
			squareSeed sqs = new squareSeed();
			System.out.println("네모꽃씨앗을 선택하셨군요!!");
			SeedPrice = sqs.SeedPrice();
			break;
		case 3:
			diamondSeed ds = new diamondSeed();
			System.out.println("다이아몬드꽃씨앗을 선택하셨군요!!");
			SeedPrice = ds.SeedPrice();
			break;
		}
		d.leftmoney(SeedPrice);
		d.defaultMenuprint();
		d.endCondition2();

		// 꽃말 맞추기 게임
		flowernameGame fng = new flowernameGame();
		fng.NameGameStart();
		String[] answer = { "동백", "장미", "해바라기", "카네이션", "튤립" };
		String[] array = new String[5];
		for (int i = 0; i < 5; i++) {
			fng.floriographyQ(i);
			array[i] = sc.next();
			boolean b = array[i].contains(answer[i]);
			if (b == true) {
				System.out.println("정답입니다!");
			} else {
				System.out.println("틀렸습니다. 정답은 " + "\"" + answer[i] + "\"" + "입니다");
			}
		}
		int countWin = fng.correctAnswer(array);
		fng.correctAnswerPrint(countWin);
		d.size = fng.flowerSize();
		d.defaultMenuprint();

		// 물길러오기 게임
		waterGame wg = new waterGame();
		wg.waterGameStart();
		System.out.println();
		System.out.println("게임은 총 10회 진행 됩니다!" + "\n게임에 성공하면 +500ml 물이 주어집니다");
		int[] com = new int[10];
		int[] user = new int[10];
		com = wg.comRandom(com);
		for (int i = 0; i < user.length; i++) {
			System.out.println();
			System.out.println(i + 1 + ". 1~3의 정수를 입력하세요!");
			user[i] = sc.nextInt();
			while (user[i] != 1 && user[i] != 2 && user[i] != 3) {
				System.out.println("1~3의 정수를 입력하지 않았습니다. 다시 한번 입력해 주세요.");
				user[i] = sc.nextInt();
			}
			if (user[i] == com[i]) {
				wg.bingo++;
				System.out.println("성공적으로 물을 길러오는데 성공했습니다!");
				System.out.println("현재 물이 " + wg.water() + "ml 있습니다!");
			} else {
				System.out.println("돌부리에 넘어져서 물이 엎어졌습니다!!");
				System.out.println("현재 물이 " + wg.water() + "ml 있습니다!");
			}
		}
		wg.waterPrint();
		d.height = wg.watergrow();
		d.defaultMenuprint();

		// 잔돈 털이
		change cm = new change();
		System.out.println("남아 있는 돈이 없어서 실행 할 수 없습니다." + "\n바로 식물을 성장시킵니다!");
		cm.changePrint(d.money);
		int yesOrNo = sc.nextInt();
		while (yesOrNo != 1 && yesOrNo != 2) {
			System.out.println("해당 숫자만 입력해주세요!" + "\n다시 입력해주세요.");
			yesOrNo = sc.nextInt();
		}
		switch (yesOrNo) {
		case 1:
			if (d.money == 0) {
				System.out.println("남아 있는 돈이 없어서 실행 할 수 없습니다." + "\n바로 식물을 성장시킵니다!");
				break;
			}
			cm.changePrint2();
			int sizeOrHeight = sc.nextInt();
			while (sizeOrHeight != 1 && sizeOrHeight != 2) {
				System.out.println("해당 숫자만 입력해주세요!" + "\n다시 입력해주세요.");
				sizeOrHeight = sc.nextInt();
			}
			switch (sizeOrHeight) {
			case 1:
				cm.howMuchPrint(cm.Sizeup);
				int su = sc.nextInt();
				while (cm.moneyToup(d.money, su) < 0) {
					System.out.println("돈이 부족합니다!" + "\n남은 돈을 확인하고 다시 입력해주세요");
					su = sc.nextInt();
				}
				if (cm.moneyToup(d.money, su) == 0) {
					System.out.println("돈을 모두 사용했습니다!" + "\n식물을 성장시킵니다!");
					d.size = d.size + su;
					d.money = cm.moneyToup(d.money, su);
				} else {
					d.size = d.size + su;
					d.money = cm.moneyToup(d.money, su);
					cm.changePrint3(d.money, cm.Heightup);
					int yesOrNo2 = sc.nextInt();
					while (yesOrNo != 1 && yesOrNo != 2) {
						System.out.println("해당 숫자만 입력해주세요!" + "\n다시 입력해주세요.");
						yesOrNo2 = sc.nextInt();
					}
					switch (yesOrNo2) {
					case 1:
						cm.howMuchPrint(cm.Heightup);
						int hu = sc.nextInt();
						while (cm.moneyToup(d.money, hu) < 0) {
							System.out.println("돈이 부족합니다!" + "\n남은 돈을 확인하고 다시 입력해주세요");
							hu = sc.nextInt();
						}
						d.height = d.height + hu;
						d.money = cm.moneyToup(d.money, hu);
						System.out.println("바로 식물을 성장시킵니다!");
						break;
					case 2:
						System.out.println("바로 식물을 성장시킵니다!");
						break;
					}
				}
				break;
			case 2:
				cm.howMuchPrint(cm.Heightup);
				int hu = sc.nextInt();
				while (cm.moneyToup(d.money, hu) < 0) {
					System.out.println("돈이 부족합니다!" + "\n남은 돈을 확인하고 다시 입력해주세요");
					hu = sc.nextInt();
				}
				if (cm.moneyToup(d.money, hu) == 0) {
					System.out.println("돈을 모두 사용했습니다!" + "\n식물을 성장시킵니다!");
					d.height = d.height + hu;
					d.money = cm.moneyToup(d.money, hu);
				} else {
					d.money = cm.moneyToup(d.money, hu);
					cm.changePrint3(d.money, cm.Sizeup);
					int yesOrNo2 = sc.nextInt();
					while (yesOrNo != 1 && yesOrNo != 2) {
						System.out.println("해당 숫자만 입력해주세요!" + "\n다시 입력해주세요.");
						yesOrNo2 = sc.nextInt();
					}
					switch (yesOrNo2) {
					case 1:
						cm.howMuchPrint(cm.Sizeup);
						su = sc.nextInt();
						while (cm.moneyToup(d.money, su) < 0) {
							System.out.println("돈이 부족합니다!" + "\n남은 돈을 확인하고 다시 입력해주세요");
							su = sc.nextInt();
						}
						d.size = d.size + su;
						d.money = cm.moneyToup(d.money, su);
						System.out.println("바로 식물을 성장시킵니다!");
						break;
					case 2:
						System.out.println("바로 식물을 성장시킵니다!");
						break;
					}
				}
				break;
			}
			break;
		case 2:
			System.out.println("잔돈털이를 하지 않고 바로 식물을 성장시켰습니다!");
			break;
		}
		d.defaultMenuprint();

		// 출력
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
				"가진돈: " + money + "  " + name + "(이)의 크기: " + size() + "  " + name + "의 키: " + height() + "cm");
		System.out.println("--------------------------------------------------------------------------");
	}

	int leftmoney(int p) {
		this.money = money - p;
		return money;
	}

	void endCondition1() {
		if (money <= 0) {
			System.out.println("돈을 다 써버려서 더이상 식물을 키울 수 없습니다!");
			System.out.println("재 실행해주세요!");
			System.exit(0);
		}
	}

	void endCondition2() {
		if (money < 0) {
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
		System.out.println("화분를 선택해주세요:)  (해당 화분의 숫자를 입력하세요.)");
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
				"## 비료 선택하기 ##" + "\n[1] *별 비료(W1000) [2] @골뱅이 비료(W2000)  [3] #우물 비료(W3000)  [4] +더하기 비료(W4000)");
		System.out.println();
		System.out.println("비료를 선택해주세요:)   (해당 비료의 숫자를 입력하세요.)");
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
		System.out.println("## 이름 짓기 ##");
		System.out.print("이름을 입력해주세요 : ");
	}
};

//------------------------------------------------------------------
class Seed {
	void SeedChoose() {
		System.out.println();
		System.out.println("## 씨앗 선택하기 ##" + "\n[1] 세모꽃 씨앗(W1000) [2] 네모꽃 씨앗(W2000)  [3] 다이아몬드꽃 씨앗(W3000)");
		System.out.println();
		System.out.println("씨앗을 선택해주세요:)    (해당 씨앗의 숫자를 입력하세요.)");
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
		System.out.println("지금부터 식물에 대한 애정도를 테스트 하기위해 꽃말 보고 맞추기게임을 실행하겠습니다!");
		System.out.println("이 게임은 애정도를 바탕으로 식물의 크기가 결정됩니다! ");
		System.out.println("5초 뒤에 시작합니다");
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
			System.out.println(i + 1 + ". 진실한  사랑, 겸손한 마음, 그대를 누구보다고 사랑합니다의 꽃말을 가진 꽃은 무엇일까요?");
			break;
		case 1:
			System.out.println(i + 1 + ". 열정, 정열, 사랑을 뜻하며 보통 프로포즈용으로 주는 꽃은?");
			break;
		case 2:
			System.out.println(i + 1 + ". 짝사랑, 흠모, 헌신을 뜻하는 꽃은?    hint:sun");
			break;
		case 3:
			System.out.println(i + 1 + ". 모정, 사랑, 부인의 애정을 뜻하며 어버이날과 스승의 날에 주는 꽃은?");
			break;
		case 4:
			System.out.println(i + 1 + ". 네덜란드의 상징이며 사랑의 고백,매혹,영원한 애정,경솔을 뜻하는 꽃은?");
			break;
		}
	}

	int correctAnswer(String[] array) {
		String[] answer = { "동백", "장미", "해바라기", "카네이션", "튤립" };
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
		System.out.println("맞힌 개수는 총" + n + "개 입니다");
	}

};

class waterGame {
	int bingo = 0;

	void waterGameStart() {
		System.out.println("다음으로 물길러오기 게임을 진행하겠습니다!");
		System.out.println("이 게임은 떠온 물의 ml에 따라 식물의 키가 결정됩니다! ");
		System.out.println("5초 뒤에 시작합니다");
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
		System.out.println("총 물을 " + water() + "ml 길러왔습니다.");
		System.out.println("식물의 키가 " + watergrow() + "cm 자랍니다!");
	}

};

class change {
	String Sizeup = "식물 크기 키우기";
	String Heightup = "식물 키 키우기";

	void changePrint(int money) {
		System.out.println();
		System.out.println("현재 당신의 돈이 " + money + "원 남아있습니다!");
		System.out.println("남아있는 돈으로 잔돈털이를 진행하시겠습니까?");
		System.out.println("[1] 네 [2] 아니요");
		System.out.println("(해당하는 숫자를 입력하세요.)");
	}

	void changePrint2() {
		System.out.println();
		System.out.println("남아있는 돈으로 잔돈털이를 진행합니다");
		System.out.println("[1]" + Sizeup + "\t" + "[2]" + Heightup);
		System.out.println("(해당하는 숫자를 입력하세요.)");
	}

	void changePrint3(int money, String str) {
		System.out.println("돈이" + money + "원 남았습니다");
		System.out.println("남은 돈으로 " + str + "를 진행 하시겠습니까?");
		System.out.println("[1] 네 [2] 아니요");
		System.out.println("(해당하는 숫자를 입력하세요.)");
	}

	void howMuchPrint(String str) {
		System.out.println();
		System.out.println(str + "를 선택하셨습니다! ");
		System.out.println("얼마만큼 키우시겠습니까? " + "\t" + str + " +1 : 200 원");
		System.out.println("(키우기 원하는 크기를 입력하세요.)");
	}

	int moneyToup(int money, int size) {
		return money - (200 * size);
	}

};

class finalPrint {
	void finalPrintStart() {
		System.out.println("식물이 곧 다 자라납니다!");
		System.out.println("3초만 기다려 주세요 :)");
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
