package codingTest2;

public class test3 {

}

interface Moveable{
	int move();
	int stop();
}

class Ball implements Moveable{

	@Override
	int move() {
		return 0;
	}

	@Override
	int stop() {
		return 0;
	}
	
}