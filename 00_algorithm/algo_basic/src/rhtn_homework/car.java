package rhtn_homework;

class Dar{
	
	private String car;

	@Override
	public String toString() {
		return "Car [car=" + car + "]";
	}
	public Dar(String car) {
		super();
		this.car = car;
	}

}


public class car{
	
	public static void main(String[] args) {
		Dar c = new Dar("내차다");
		System.out.println(c);
	}
	
	
}

