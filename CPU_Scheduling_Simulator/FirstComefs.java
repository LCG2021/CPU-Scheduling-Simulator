import java.text.ParseException;

public class FirstComefs 
{
	
	
	static void ResponseTime( int processes[], int butime[], int
			TurnAroundTime[], int res[], int L)
	{
		for(int i = 0; i < L; i++)
			res[i] = TurnAroundTime[i] - butime[i];
	}
	
	static void TurnAroundTime(int processes [], 
			int butime[], int wt[], int TurnAroundTime[], int
			L) {
		
		for(int i = 0; i < L; i++) {
			
			TurnAroundTime[i] = butime[i] + wt[i];
		}
	}
	
	static void WaitingTime (int processes[], 
			int butime[], int WaitingTime[], int L) {
		
		WaitingTime[0] = 0;
		
		
		for(int i = 1; i < L; i++) {
			WaitingTime[i] = butime[i-1] + WaitingTime[i-1];
		}
	}
	
	static void TimeAVG(int processes [], int butime[], int L) {
		int WaitingTime[] = new int[L], TurnAroundTime[] = new
				int[L];
		
		int res[] = new int[L];
		
		int total_wt = 0; 
		int total_TurnAroundTime = 0; 
		int total_res = 0;
		
		WaitingTime(processes, butime, WaitingTime, L);
		
		TurnAroundTime(processes, butime, WaitingTime,
				TurnAroundTime, L);
		
		ResponseTime(processes, butime, TurnAroundTime, 
				res, L);
		
		System.out.println(" Processes Burst time Waiting"
				+ "time Turn around time\n");
		
		for(int i =0; i < L; i++) {
			
			total_wt = total_wt + WaitingTime[i];
			total_TurnAroundTime = total_TurnAroundTime +
					TurnAroundTime[i];
			
			total_res = total_res + res[i];
			
			System.out.printf("  %d ", (i + 1));
			System.out.printf("             %d ", butime[i]);
			System.out.printf("               %d ", WaitingTime[i]);
			System.out.printf("                %d\n "  , 
					TurnAroundTime[i]);
		}
		
		float s = (float) total_wt/ (float) L;
		int t = total_TurnAroundTime / L;
		
		int r = total_res / L;
		System.out.printf("Average waiting time:     %f", s);
		System.out.printf("\n");
		System.out.printf("Average turn around time:     %d   ", 
				t);
		System.out.printf("\n");
		System.out.printf("Average response time:     %d   ", r);
		
              
	}
	

	
	
	public static void main (String [] args) throws ParseException{
	// process id's
		int processes[] = {1, 2, 3};
		int L = processes.length;
		// Burst time of all processes
		int burst_time[] = {10, 5, 8};
		TimeAVG(processes, burst_time, L);
		
	}
	
}


