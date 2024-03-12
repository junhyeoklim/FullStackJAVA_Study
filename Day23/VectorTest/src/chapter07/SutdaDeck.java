package chapter07;

public class SutdaDeck {
	private static final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	public SutdaDeck() {
		boolean flag = false;
		for(int i=0;i<cards.length/10;i++)
		{
			for(int j=0;j<cards.length/2;j++)
			{
				if(i == 0 && ((j+1) == 1 || (j+1) == 3 || (j+1) == 8))
					flag = true;
				else
					flag = false;
				cards[j+cards.length/2*i] = new SutdaCard(j+1,flag);
			}
		}
	}

	public void shuffle() {
		for(int i=0;i<cards.length;i++)
		{
			int idx = (int) (Math.random()*cards.length);
			SutdaCard temp = cards[idx];
			cards[idx] = cards[i];
			cards[i] = temp;
		}
	}
	public SutdaCard pick(int index)
	{
			return cards[index];
	}
	
	public SutdaCard pick()
	{
		int idx = (int) (Math.random()*cards.length);
		return cards[idx];
	}
}
