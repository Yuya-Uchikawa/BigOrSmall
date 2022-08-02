package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//BigOrSmall: 繰り返しプレイするゲーム全体を管理するクラス。残りゲーム回数や、現在のスコアなどを管理する.
public class BigOrSmall {

	private int remain;// 残りゲーム回数
	private int score;// 現在のスコア
	private int continuousCorrectAnswer=0;//連続正解数


    public BigOrSmall(){//**constructer
    	remain = 10;
    	score = 0;
    }

    public void play(){//**ゲーム開始
    	System.out.println("Big or Smallをプレイします。");
    	BigOrSmallGame BigOrSmallGame = new BigOrSmallGame();
    	while(remain>0) {
    		showPlayerData();
    		int result = BigOrSmallGame.play();
    		showResult(result);
    	}
    	showScore();
    	resisterResult();
    }

    private void showPlayerData() {
    	System.out.println("残りプレイ回数: " + remain);
	    System.out.println("現在のスコア: " + score);
    }

    private void showResult(int result) {
    	if(result==2) {
    		System.out.println("Draw!\r\n");
    	}else if(result==1) {
    		System.out.println("正解!\r\n ");
    		continuousCorrectAnswer++;
    		score += 100 * continuousCorrectAnswer;
    		remain--;
    	}else {
    		System.out.println("不正解!\r\n ");
    		continuousCorrectAnswer=0;
    		remain--;
    	}
    }

    private void showScore() {
    	System.out.println("最終スコア： " + score);
    	System.out.println("お疲れ様でした。");
    }

    private void resisterResult() {
    	try{
    		  Path path = Paths.get("src/test/log.txt");
    	      Path absolutePath = path.toAbsolutePath();
    	      File file = new File(absolutePath.toString());

    	      if (checkBeforeWritefile(file)){
    	        FileWriter filewriter = new FileWriter(file);
    	        filewriter.write("スコア： " + score + " " + getCurrentDate() +"\r\n");
    	        filewriter.close();
    	      }else{
    	        System.out.println("ファイルに書き込めません");
    	      }
    	    }catch(IOException e){
    	      System.out.println(e);
    	    }
    }

    private static boolean checkBeforeWritefile(File file){
        return (file.exists() && file.isFile() && file.canWrite());
    }

    private String getCurrentDate() {
    	LocalDateTime date = LocalDateTime.now();
    	DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss +0900");
    	return formatedDate.format(date);
    }

}