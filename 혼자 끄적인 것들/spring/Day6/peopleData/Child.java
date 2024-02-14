package peopleData;

import data.ChildGetSet;

public class Child {
	
	ChildGetSet child = new ChildGetSet();	
	
	public Child(String name,int beads)
	{
		child.setName(name);
		child.setBeads(beads);
	}
	
	public void win(Child child,int cnt)
	{
		this.child.setBeads(this.child.getBeads() + child.lose(cnt));
		childStatus();
	}
	
	public int lose(int cnt)
	{
		//현재 내가 보유하고 있는 구슬 갯수가 줘야 할 갯수보다 작을 경우를 대비 한 if문
		if(child.getBeads() < cnt)
		{
			int temp = child.getBeads();
			child.setBeads(0);
			return temp;
		}
		child.setBeads(child.getBeads()-cnt);
		return cnt;
	}
	
	public void childStatus()
	{
		System.out.println("이름 : "+child.getName());
		System.out.println("현재 보유하고 있는 구슬 갯수 "+child.getBeads());
	}
}
