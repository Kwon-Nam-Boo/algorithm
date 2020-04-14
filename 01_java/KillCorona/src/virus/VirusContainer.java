package virus;

import java.util.ArrayList;
import java.util.List;

// 사용하는 시점에서 타입 결정 된다 T
public class VirusContainer<T> {
	private List<T> virusList = new ArrayList<T>();
	
	public List<T> getVirusList() {
		return virusList;
	}

	public void setVirusList(List<T> virusList) {
		this.virusList = virusList;
	}

	public static void main(String[] args) {
		VirusContainer<Corona> container = new VirusContainer<Corona>();
		container.getVirusList().add(new Corona("covid19",10,"A10"));
		System.out.println(container.getVirusList().get(0).getName());

	}

}
