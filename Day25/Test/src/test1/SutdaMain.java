package test1;

public class SutdaMain {

	public static void main(String[] args)
	{
		SutdaDeck sut = new SutdaDeck();
		System.out.println(sut.sutdacard[19]+",");
		for(int i=0; i<sut.sutdacard.length;i++)
		{
			System.out.print(sut.sutdacard[i]+",");
		}
		System.out.println();
		System.out.println(sut.pick(1));
		sut.shuffle();
		System.out.println(sut.pick());
		
		for(int i=0; i<sut.sutdacard.length;i++)
		{
			System.out.print(sut.sutdacard[i]+",");
		}
	}
}
