package test;

import java.util.Comparator;
import java.util.TreeMap;



class SutdaDeck
{
	TreeMap<String, Integer> jokbo = new TreeMap<>();
	SutdaCard[] card = new SutdaCard[20];
	int pos;
	public SutdaDeck() {
		int num =0;

		for(int i=0;i<card.length;i++)
		{
			num = i%10+1;
			boolean isKwang = i < 10 && (num==1 || num==3 || num==8);
			card[i] = new SutdaCard(num,isKwang);
		}
		jokbo();
	}

	SutdaCard pick() throws Exception
	{		
		SutdaCard c = null;
		if(0 <= pos && pos < 20) {
			c = card[pos];
			card[pos++] = null;
		} else {
			throw new Exception("남아있는 카드가 없습니다."); 
		}
		return c;
	}
	int getPoint(Player p)
	{
		SutdaCard card1 = p.card1;
		SutdaCard card2 = p.card2;
		Integer result = 0;
		
		if(card1.isKwang && card2.isKwang)
			result = jokbo.get("KK");
		else 
			result = jokbo.get(""+card1.num+card2.num);
		if(result == null)
		{
			result = (card1.num + card2.num) %10 +1000;
		}
		
		return result;
	}
	
	public void jokbo()
	{		
		jokbo.put("KK", 4000);

		jokbo.put("1010", 3100);
		jokbo.put("99", 3090);
		jokbo.put("88", 3080);
		jokbo.put("77", 3070);
		jokbo.put("66", 3060);
		jokbo.put("55", 3050);
		jokbo.put("44", 3040);
		jokbo.put("33", 3030);
		jokbo.put("22", 3020);
		jokbo.put("11", 3010);

		jokbo.put("12", 2060);
		jokbo.put("21", 2060);
		jokbo.put("14", 2050);
		jokbo.put("41", 2050);
		jokbo.put("19", 2040);
		jokbo.put("91", 2040);
		jokbo.put("110", 2030);
		jokbo.put("101", 2030);
		jokbo.put("410", 2020);
		jokbo.put("104", 2020);
		jokbo.put("46", 2010);
		jokbo.put("64", 2010);
	}

	void shuffle()
	{
		for(int x=0; x < 20; x++) {
			int i = (int)(Math.random() * 20);
			int j = (int)(Math.random() * 20);
			SutdaCard tmp = card[i];
			card[i] = card[j];
			card[j] = tmp;
		}
	}
}

class Player
{
	String name;
	SutdaCard card1;
	SutdaCard card2;
	int point;

	public Player(String name,SutdaCard card1,SutdaCard card2) {
		this.name = name;
		this.card1 = card1;
		this.card2 = card2;
	}

	@Override
	public String toString() {
		return "["+name+"]"+card1.toString() +","+card2.toString();
	}
}
class SutdaCard {
	int num;
	boolean isKwang;
	SutdaCard() {
		this(1, true);
	}
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	public String toString() {
		return num + ( isKwang ? "K":"");
	}
}
public class Test3 {

	public static void main(String[] args) throws Exception {
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
	
			Player[] pArr = {
					new Player("타짜", deck.pick(), deck.pick()), 
					new Player("고수", deck.pick(), deck.pick()), 
					new Player("물주", deck.pick(), deck.pick()), 
					new Player("중수", deck.pick(), deck.pick()), 
					new Player("하수", deck.pick(), deck.pick())
			};
		TreeMap<Player, Integer> sutdaPlay = new TreeMap<>(new Comparator<Player>() {

			@Override
			public int compare(Player o1, Player o2) {
				return o1.point - o2.point;
			}
		});
		
		for(int i=0;i<pArr.length;i++)
		{			
			sutdaPlay.put(pArr[i], deck.getPoint(pArr[i]));
			System.out.println(pArr[i]+" "+deck.getPoint(pArr[i]));
		}
	}

}



