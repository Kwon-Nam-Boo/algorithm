package codingTest2;

public class test3 {

}

interface Moveable{
	default int move() {
		return 0;
	};
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