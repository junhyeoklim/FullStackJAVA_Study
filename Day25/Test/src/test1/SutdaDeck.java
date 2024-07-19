package test1;

public class SutdaDeck {
	SutdaCard[] sutdacard = new SutdaCard[20];
	
	
	public SutdaDeck() {
		boolean flag = false;
		for(int i=0; i<sutdacard.length/10;i++)
		{
			
			for(int j=0;j<sutdacard.length/2;j++)
			{
				if(i ==0 && ( j== 1 || j == 3 || j == 8))
					flag = true;
				else
					flag = false;
				sutdacard[j+sutdacard.length/2*i] = new SutdaCard(j+1,flag);
			}
		}
	}
	
	public void shuffle()
	{		
		for(int i =0;i<sutdacard.length;i++)
		{
			int idx = (int) (Math.random()*sutdacard.length);
			SutdaCard temp = sutdacard[i];
			sutdacard[i] = sutdacard[idx];
			sutdacard[idx] = temp;			
		}

	}
	
	public SutdaCard pick(int index)
	{
		return sutdacard[index];
	}
	
	public SutdaCard pick()
	{
		int idx = (int) (Math.random()*sutdacard.length);
		return sutdacard[idx];
	}
}
