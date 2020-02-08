package com.object;

public class Movie {
	
	String title;
	String director;
	int grade;
	String genre;
	String summary;
	
	public void movieInfo() {
		System.out.println(title);
		System.out.println(director);
		System.out.println(grade);
		System.out.println(genre);
		System.out.println(summary);
	}
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", grade=" + grade + ", genre=" + genre
				+ ", summary=" + summary + "]";
	}
	
}
