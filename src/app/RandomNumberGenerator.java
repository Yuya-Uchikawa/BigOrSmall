package app;
import java.util.Random;

public class RandomNumberGenerator {
    /** 任意の範囲のランダムな整数を生成するクラス */
	public int generateRandomNumber() {
		Random random = new Random();
		return  random.nextInt(9) + 1;//1～9までの整数をランダムに返す
	}
}
