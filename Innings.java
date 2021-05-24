import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Innings {
	int runs=0, wickets=0;
	int str=0, non_str=1;
	Scanner sc = new Scanner(System.in);
	String[] Team = new String[11];
	int[] PlayerScore = new int[11];
	int[] PlayerBalls = new int[11];
	void addTeam()
	{
		for(int i=0;i<11;i++)
		{
			Team[i]=sc.nextLine();
		}
	}
	void displayTeam()
	{
		System.out.println("Playing XI:");
		for(int i=0;i<11;i++)
		{
			System.out.println(i+1 + ". " + Team[i]);
		}
	}
	void strikeChange()
	{
		int temp;
		temp = this.non_str;
		this.non_str=this.str;
		this.str = temp;
	}
	void ball()
	{
		double r = Math.random()*120;
		int random = (int) r;
		/*probw = 5/120;
		prob0 = 30/120;
		prob1 = 40/120;
		prob2 = 20/120;
		prob3 = 5/120;
		prob4 = 10/120;
		prob6 = 10/120;*/
		if(random<5)
		{
			this.wickets+=1;
			this.PlayerBalls[this.str]+=1;
			if(this.str==10 || this.non_str==10)
				this.str=this.non_str;
			else if(this.str<this.non_str)
				this.str=this.non_str+1;
			else
				this.str+=1;
			System.out.print("W ");
		}
		else if(random<35)
		{
			this.runs+=0;
			this.PlayerBalls[this.str]+=1;
			System.out.print("0 ");
		}
		else if(random<75)
		{
			this.runs+=1;
			this.PlayerScore[this.str]+=1;
			this.PlayerBalls[this.str]+=1;
			strikeChange();
			System.out.print("1 ");
		}
		else if(random<95)
		{
			this.runs+=2;
			this.PlayerScore[this.str]+=2;
			this.PlayerBalls[this.str]+=1;
			System.out.print("2 ");
		}
		else if(random<100)
		{
			this.runs+=3;
			this.PlayerScore[this.str]+=3;
			this.PlayerBalls[this.str]+=1;
			strikeChange();
			System.out.print("3 ");
		}
		else if(random<110)
		{
			this.runs+=4;
			this.PlayerScore[this.str]+=4;
			this.PlayerBalls[this.str]+=1;
			System.out.print("4 ");
		}
		else 
		{
			this.runs+=6;
			this.PlayerScore[this.str]+=6;
			this.PlayerBalls[this.str]+=1;
			System.out.print("6 ");
		}
	}
		void score()
		{
			System.out.println("\nScore: " + this.runs + "/" + this.wickets);
			System.out.println(this.Team[this.str] + "\nRuns:" + this.PlayerScore[this.str] + "\tBalls:" + this.PlayerBalls[this.str]);
			System.out.println(this.Team[this.non_str] + "\nRuns:" + this.PlayerScore[this.non_str] + "\tBalls:" + this.PlayerBalls[this.non_str]);
		}
		void scorecard()
		{
			System.out.println("\nScorecard:");
			for(int i=0;i<11;i++)
			{
				System.out.println(i+1 + ". " + Team[i] + "\nRuns:" + PlayerScore[i] + "\tBalls:" + PlayerBalls[i]);
			}
		}
	public static void main(String[] args) {
		Innings in = new Innings();
		int overs=20, balls=6, i, j;
		System.out.println("Enter the name of the 11 players:");
		in.addTeam();
		in.displayTeam();
		in.score();
		for(i=1;i<=overs;i++)
		{
			System.out.print("\nOver " + i + ":");
			for(j=1;j<=balls;j++)
			{
				in.ball();
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(in.wickets==10)
					break;
			}
			in.strikeChange();
			in.score();
			if(in.wickets==10)
				break;
			}
		in.scorecard();
	}
}
