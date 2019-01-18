package inventorySystem;
import java.util.Scanner;
class Video{
	String title;
	boolean flag;
	int userrating;
	public boolean beingCheckedOut()
	{
		if(this.flag==false)
		{
			System.out.println("Video unavailable!");
			return false;
		}
		this.flag=false;
		System.out.print(this.title+" is being checked out!");
		return flag;
	}
	public boolean beingReturned(int rating)
	{
		this.flag=true;
		this.recieveRating(rating);
		System.out.println("Rating for "+this.title+" is: "+rating);
		return flag;
	}
	public int recieveRating(int rating)
	{	
		userrating =(userrating+rating)/2;
		return this.userrating;
	}
	public void addTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}
}
public class InventorySystem {
	public static void main(String args[])
	{
		Video[] v = new Video[20];
		Scanner ob = new Scanner(System.in);
		int n,c,rating;
		boolean ch=true;
		String title;
		System.out.println("Enter number of video titles: ");
		n = ob.nextInt();
		for(int i=0;i<n;i++)
		{
			v[i] = new Video();
			System.out.println("Enter title: ");
			title = ob.next();
			v[i].addTitle(title);
		}
		while(ch!=false){
			System.out.println("1. Add title ");
			System.out.println("2. Check a video out ");
			System.out.println("3. Return a video ");
			System.out.println("4. Exit ");
			c = ob.nextInt();
			switch(c)
			{
			case 1:
				System.out.println("Enter title: ");
				
				title = ob.next();
				n++;
				v[n]=new Video();
				v[n].addTitle(title);
				break;
			case 2:
				System.out.println("Enter title to rent: ");
				title = ob.next();
				for(int i=0;i<n;i++)
				{
					if (v[i].getTitle().equals(title))
					{
						v[i].beingCheckedOut();
					}
				}
				break;
			case 3:
				System.out.println("Enter title to return: ");
				title = ob.next();
				System.out.println("Enter rating:");
				rating = ob.nextInt();
				for(int i=0;i<n;i++)
				{
					if (v[i].getTitle().equals(title))
					{
						v[i].beingReturned(rating);
					}
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Incorrect input!");
			}
			
			
			System.out.println("Another transaction?(T/F): ");
			ch = ob.nextBoolean();
		}
		
	}
}
