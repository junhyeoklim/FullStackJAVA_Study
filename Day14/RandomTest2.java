import java.util.Random;

class RandomTest2
{

	public static void main(String[] args)
	{	//1번
		int[] lotto = new int[6];
		int num = 0;
		Random random = new Random();


		for(int i=0; i<lotto.length-1;i++)
		{
			System.out.print((char)('A'+i)+" 자 동"+"\t");
			lotto[i] = random.nextInt(45)+1;


			for(int y=0; y<i;y++)
			{
				if(lotto[i] == lotto[y])
					i--;			
			}
			for(int k =0; k<lotto.length;k++)
				System.out.println(lotto[k]+"\t");
			System.out.println();
		}

	}
}

