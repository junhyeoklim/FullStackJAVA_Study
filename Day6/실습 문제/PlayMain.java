/*1. 어린아이가 소유하고 있는 구슬의 개수 정보
2. 놀이를 통한 구슬의 주고 받음 -> 메소드
3. 어린이의 현재 보유 자산을 출력하는 메소드





*/

class Child
{
	int cnt;
	String name;

	public Child(String name,int cnt)
	{
		this.cnt = cnt;
		this.name = name;
	}

	public void win(Child child,int cnt)
	{
		this.cnt += child.lose(cnt);
	}

	public int lose(int cnt)
	{
		if(this.cnt < cnt)
		{
			int temp = this.cnt;
			this.cnt = 0;
			return temp;
		}
		this.cnt -= cnt;
		return cnt;
	}

	public void childStatus()
	{
		System.out.println("이름 : "+name);
		System.out.println("현재 보유중인 구슬의 갯수 : "+cnt);
	}
}

class PlayMain
{
	public static void main(String[] args)
	{
		Child c1 = new Child("어린이1",15);
		Child c2 = new Child("어린이2",7);


		c1.win(c2,8);

		c1.childStatus();
		c2.childStatus();
	}
}
