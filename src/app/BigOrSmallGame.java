package app;

public class BigOrSmallGame {
	/** 各回のゲームを管理するクラス */
	private int preNumber=0;
	private int correntNumber=0;
	private String[] option = {"Big", "Small", "Draw"};


	public int play() {
		RandomNumberGenerator RandomNumberGenerator = new RandomNumberGenerator();

		if(preNumber == 0) {
		    preNumber = RandomNumberGenerator.generateRandomNumber();
		}
		correntNumber = RandomNumberGenerator.generateRandomNumber();

		System.out.println("現在の数値: "+preNumber);

		int optionIndex = -1;

		while(true) {
			Player Player = new Player();
			optionIndex = Player.inputNumber();
			if( optionIndex == -1 ) {
		    	System.out.println("不正な入力です。");
			}else if( optionIndex != 0 && optionIndex != 1){
				System.out.println("0または1で入力してください。");
			}else {
				break;
			}
		}

		int answer = -1;

		if(preNumber == correntNumber) {
			answer = 2;
		} else if(preNumber > correntNumber) {
			answer = 1;
		} else {
			answer = 0;
		}
		System.out.println(option[optionIndex]+" 現在の数値: "+preNumber+" 次の数値: "+correntNumber);

		preNumber = correntNumber;

		if(answer==2) {
			return 2;//引き分け
		}else if(answer==optionIndex) {
			return 1;//正解
		}else {
			return 0;//不正解
		}
	}

}
