package com.ssafy;

public class MovieMgr extends Movie {
	
	private Movie[] movies = new Movie[100];
	private int index;
	
	private static MovieMgr instance;
	
	public static MovieMgr getinstance() {
		if(instance == null) {
			instance = new MovieMgr();
		}
		return instance;
	}
	
	public void add(Movie m) {
		movies[index++]=m;
	}
	public Movie[] search() {
		return movies;
	}
	public Movie[] search(String title) {
		Movie[] tmp = new Movie[100];
		int idx=0;
		for(Movie mv : movies) {
			if(mv==null) break;
			if(mv.getTitle().contains(title)) {
				tmp[idx++] = mv;
			}
		}
		return tmp;
	}
	
	public Movie[] searchDirector(String name) {
		Movie[] tmp = new Movie[100];
		int idx=0;
		for(Movie mv : movies) {
			if(mv==null) break;
			if(mv.getDirector().equals(name)) {
				tmp[idx++] = mv;
			}
		}
		return tmp;
	}
	
	public Movie[] searchGenre(String genre) {
		Movie[] tmp = new Movie[100];
		int idx=0;
		for(Movie mv : movies) {
			if(mv==null) break;
			if(mv.getGenre().equals(genre)) {
				tmp[idx++] = mv;
			}
		}
		return tmp;
	}
	
	public void delete(String title) {
		
		int c =0;
		for(Movie mv : movies) {
			if(mv==null) break;
			if(mv.getTitle().equals(title)) {
				for (int i = c; i < movies.length-1; i++) {
					movies[i] = movies[i+1];
				}
				index--;
				return;
			}
			c++;
		}
	
		
	}
	public int getSize() {
		return index;
	}
	

}
