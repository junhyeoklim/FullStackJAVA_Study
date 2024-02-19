class Rectangle
{
	private int ulx, uly;		// 좌 상단 x, y 좌표
	private int lrx, lry;		// 우 하단 x, y 좌표


	public void setRectangle(int ulx,int uly, int lrx, int lry)
	{
		this.ulx=ulx;
		this.uly=uly;
		this.lrx=lrx;
		this.lry=lry;

		if(ulx < 0 || lrx >100 && uly < 0 || lry > 100)
		{
			System.out.println("좌표값을 다시 입력 해주세요!");
		}
		else if(lrx < ulx || lry< uly)
		{
			System.out.println("좌표값을 다시 입력 해주세요!");
		}
	}

	public void showArea()
	{

		int xLen = lrx-ulx;
		int yLen = lry-uly;
		System.out.println("넓이 : " + (xLen*yLen));
	}
}


class RectangleTest
{
	public static void main(String[] args)
	{
		Rectangle rec = new Rectangle();
		rec.setRectangle(0,100,5,5);
		rec.showArea();
	}
}