package app;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	/** プレイヤーの入力内容を管理するクラス*/

	public int inputNumber() {
		int option=-1;

	    try {
	    	Scanner scanner = new Scanner(System.in);
	    	System.out.println("次の数値はBig or Small?(Big: 0 Small: 1)");
	    	option = scanner.nextInt();

	    }catch(InputMismatchException e) {
	    	option=-1;
	    }
	    return option;
	}
}
