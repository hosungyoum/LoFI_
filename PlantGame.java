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
		System.out.println("가진돈: " + money + "  " + name + "의 크기: " + size() + "  " + name + "의 키: " + height() + "cm");
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

		String s1 = "?"; // 화분 모양 1
		String s2 = "$";
		String blank = " ";// 화분 만들때 쓰일 공백

		defaultMenu d = new defaultMenu();
		d.defaultMenuprint();
		// 화분 선택 부분
		// 화분 가격을 potprice라고 저장했을 경우
		int potprice = 5000; // 예시입니다.
		d.leftmoney(potprice);
		d.defaultMenuprint();

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

