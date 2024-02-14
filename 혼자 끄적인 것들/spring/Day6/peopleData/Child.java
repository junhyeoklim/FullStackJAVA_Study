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
	}
	
	public int lose(int cnt)
	{
		child.setBeads(child.getBeads()-cnt);
		return cnt;
	}
	
	public void childStatus()
	{
		System.out.println("이름 : "+child.getName());
		System.out.println("현재 보유하고 있는 구슬 갯수 "+child.getBeads());
	}
}
