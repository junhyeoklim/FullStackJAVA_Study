package test1;

public class SutdaCard {
	
		private int num;
		private boolean check;
	public SutdaCard() {
		this(1,true);
	}
	
	public SutdaCard(int num,boolean check)
	{
		this.num = num;
		this.check = check;
	}
		
	@Override
	public String toString() {
		return num+(check ?  "K" : "");
	}

}
