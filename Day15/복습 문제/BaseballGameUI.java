import java.util.Random;
import java.util.Scanner;





public class BaseballGameUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfDigits = 0;
		int iNum = 0;
		System.out.println("숫자 야구 게임을 시작합니다.");
		while(true)
		{			
			System.out.println("원하는 자리수를 선택하세요.");
			System.out.println("1~9까지 선택가능");
			numberOfDigits = sc.nextInt();
			if(numberOfDigits >=1 && numberOfDigits <= 9) break;
			System.out.println("잘못 입력하셨습니다.");
		}
		
		BaseballGame bbGame = new BaseballGame(numberOfDigits);		
		
		while(true)
		{
			boolean result;
			System.out.println("자 공격하세요.");
			iNum = sc.nextInt();
			result = bbGame.playBaseballGame(iNum);
			if(result)
			{
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
		sc.close();
	}
}

class Baseball {
	private final int MAX;
	private int[] baseBall;
	private int[] attBaseBall;
	private Random rnd;
	public final int START_NUM;
	public final int END_NUM;
	private int bCnt;
	private int sCnt;
	
	public Baseball(int numberOfDigits) {
		MAX = numberOfDigits;
		baseBall = new int[MAX];
		attBaseBall = new int[MAX];
		rnd = new Random();
		START_NUM = setStartRange();
		END_NUM = START_NUM*10-1;
		makeRNum(baseBall);
		printArr();	// 디버깅	용도
	}

	private int setStartRange()
	{
		int num = 1;
		for(int i=0;i<MAX-1;i++)
			num *= 10;
		return num;
	}
	
	private boolean numRange(int num)
	{
		if(num<START_NUM || num>END_NUM) return false;
		else return true;
	}	
	
	private void makeRNum(int[] arrNum)
	{
		while(true)
		{
			int rNum = rnd.nextInt(END_NUM-START_NUM+1)+START_NUM;
			mkArr(arrNum, rNum);
			if(chkNumArr(arrNum)) break;				
		}
	}
	
	private void mkArr(int[] arrNum, int num)
	{		
		int divisor = 1;
		for(int i=0;i<arrNum.length-1;i++)
			divisor *= 10;
		for(int i=0;i<arrNum.length;i++)
		{
			arrNum[i] = num / divisor;
			num %= divisor;
			divisor /= 10;
		}		
	}
	
	private boolean chkNumArr(int[] arrNum)
	{
		for(int i=0;i<arrNum.length-1;i++)
		{
			for(int j=i+1;j<arrNum.length;j++)
			{
				if(arrNum[i]==arrNum[j])
					return false;
			}
		}
		return true;
	}
	
	private void printArr()
	{
		for(int i=0;i<baseBall.length;i++)
			System.out.print(baseBall[i]);
		System.out.println();
	}	
	public boolean setINum(int num)
	{
		boolean result = true;
		if(numRange(num))
		{
			mkArr(attBaseBall, num);
			result = chkNumArr(attBaseBall);
		}
		else result = false;
		return result;
	}
	
	public void playGame()
	{
		int sCnt = 0;
		int bCnt = 0;
		for(int i=0;i<baseBall.length;i++)
		{
			for(int j=0;j<attBaseBall.length;j++)
			{
				if(baseBall[i] == attBaseBall[j])
				{
					if(i==j) sCnt++;
					else bCnt++;
				}
			}
		}
		this.sCnt = sCnt;
		this.bCnt = bCnt;
	}
	
	public boolean showResult()
	{
		boolean result = false;
		if(sCnt==MAX)
		{
			System.out.println("홈런");
			result = true;
		}
		else if(sCnt==0 && bCnt == 0)
			System.out.println("아웃");
		else
			System.out.println(sCnt + " 스트라잌 " + bCnt + " 볼");
		return result;		
	}
}


class BaseballGame {
	
	private Baseball computer;

	public BaseballGame(int numberOfDigits) {
		this.computer = new Baseball(numberOfDigits);
	}
	
	private boolean attack(int num)
	{
		return computer.setINum(num);
	}
	
	public boolean playBaseballGame(int num)
	{
		boolean result = false;
		if(attack(num))
		{
			computer.playGame();
			result = computer.showResult();			
		}
		else
			System.out.println("숫자는 " + computer.START_NUM + "이상 " + computer.END_NUM + " 이하의 겹치지 않는 숫자여야 합니다.");
		return result;
	}
}