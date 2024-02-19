import java.util.Random;

class Excercise7
{
	public static void main(String[] args)
	{
		int dice = 0,cnt = 0;
		Random ran = new Random();

		while(true)
		{
			dice = ran.nextInt(6)+1;
			cnt ++;
			System.out.println("("+dice+")");
			
			if(dice == 6)
			{
				System.out.println("총 주사위 굴린 횟수는 : "+cnt+"회");
				break;
			}
		}
	}
}