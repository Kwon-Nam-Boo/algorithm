package rhtn_homework;

public class PROG_추석트래픽 {

	public static void main(String[] args) {
		PROG_추석트래픽 prog = new PROG_추석트래픽();
		String[] lines = {"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"
		};
		System.out.println(prog.solution(lines));

	}

	public int solution(String[] lines) {
        int answer = 0;
        int[] startTime = new int[lines.length];
        int[] endTime = new int[lines.length];
        
        getTimes(lines, startTime, endTime);
        
        // 시작점을 기준으로 1초
        for (int i = 0; i < lines.length; i++) {
        	int cnt = 0;
        	// 시작점부터 1초 까지의 처리개수를 확인할거다
        	int startOfSection = startTime[i];
        	int endOfSection = startOfSection + 1000;
        	

			for (int j = 0; j < lines.length; j++) {
				// 조건 1. 해당 작업의 '시작점'이 (기준의 시작점이상 끝점미만)사이라면
				if(startTime[j] >= startOfSection && startTime[j] < endOfSection) cnt++;
				// 조건 2. 해당 작업의 '끝점'이 (기준의 시작점이상 끝점미만)사이라면
				else if(endTime[j] >= startOfSection && endTime[j] < endOfSection) cnt++;
				// 조건 3. 해당 작업이 현재 기준을 포함하는 경우 
				else if(startTime[j] <= startOfSection && endTime[j] >= endOfSection) cnt++;
			}
			answer = Math.max(answer, cnt);
		}
        
        // 끝점을 기준으로 1초
        for (int i = 0; i < lines.length; i++) {
        	int cnt = 0;
        	// 시작점부터 1초 까지의 처리개수를 확인할거다
        	int startOfSection = endTime[i];
        	int endOfSection = startOfSection + 1000;

			for (int j = 0; j < lines.length; j++) {
				// 조건 1. 해당 작업의 '시작점'이 (기준의 시작점이상 끝점미만)사이라면
				if(startTime[j] >= startOfSection && startTime[j] < endOfSection) cnt++;
				// 조건 2. 해당 작업의 '끝점'이 (기준의 시작점이상 끝점미만)사이라면
				else if(endTime[j] >= startOfSection && endTime[j] < endOfSection) cnt++;
				// 조건 3. 해당 작업이 현재 기준을 포함하는 경우 
				else if(startTime[j] <= startOfSection && endTime[j] >= endOfSection) cnt++;
			}
			answer = Math.max(answer, cnt);
		}
        
        return answer;
    }

	private void getTimes(String[] lines, int[] startTime, int[] endTime) {
		for (int i = 0; i < lines.length; i++) {
			// 로그
			String[] log = lines[i].split(" ");
			// 시분초
			String[] responseTime = log[1].split(":");
			
			int processingTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length()-1))*1000);
			int start = 0;
			int end = 0;
			

			// 끝점(밀리초단위 이므로)
			end += Integer.parseInt(responseTime[0])*60*60*1000;
			end += Integer.parseInt(responseTime[1])*60*1000;
			end += (int)(Double.parseDouble(responseTime[2])*1000);
			
			// 시작점
			start = end - processingTime + 1;
			
			startTime[i] = start;
			endTime[i] = end;
		}
		
	}
	
}
