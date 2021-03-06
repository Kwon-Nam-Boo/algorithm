package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MovieTest {

	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		MovieMgr mg1 = MovieMgr.getinstance();
		MovieMgr mg2 = MovieMgr.getinstance();
		MovieMgr mg3 = MovieMgr.getinstance();
		
		mg1.add(new Movie("범죄도시", "강윤성", 15, "범죄", "마동석"));
		mg2.add(new Movie("겨울왕국", "디즈니", 7, "애니메이션", "렛잇고"));
		mg3.add(new Movie("명량", "김한민", 12, "역사", "국뽕"));
		

		int flag =1;
		
		while(flag==1) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("6. 영화 개수");
			System.out.println("7. 영화 감독으로 검색");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요. _");
			
			int N = Integer.parseInt(br.readLine());
			
			switch(N) {
				case 1:
					st = new StringTokenizer(br.readLine());
					String title = st.nextToken();
					String director = st.nextToken();
					int grade = Integer.parseInt(st.nextToken());
					String genre = st.nextToken();
					String summary = st.nextToken();
					mg1.add(new Movie(title, director, grade, genre, summary));
					break;
				case 2:
					for(Movie mv:mg1.search()) {			// 영화 전체 출력
						if(mv==null) break;
						System.out.println(mv);
					}
					break;
				case 3:
					String src = br.readLine();
					for(Movie mv:mg1.search(src)) {		// 검색한 영화감독의 영화 출력
						if(mv==null) break;
						System.out.println(mv);
					}
					break;
				case 4:
					String src2 = br.readLine();
					for(Movie mv:mg1.searchGenre(src2)) {		// 검색한 장르의 영화 출력
						if(mv==null) break;
						System.out.println(mv);
					}
					break;
				case 5:											// 영화 삭제
					String src3 = br.readLine();
					mg1.delete(src3);
					System.out.println("삭제되었습니다!");
					break;
				case 6:
					System.out.println(mg1.getSize()+"개 입니다!");		// 영화 개수
					break;
				case 7:
					String src4 = br.readLine();
					for(Movie mv:mg1.searchDirector(src4)) {		// 검색한 영화감독의 영화 출력
						if(mv==null) break;
						System.out.println(mv);
					}
					break;
				case 0:
					System.out.println("끝!");
					flag=0;
					break;
					
			}
			System.out.println();
			
		}
		
		
		
	}	

}
