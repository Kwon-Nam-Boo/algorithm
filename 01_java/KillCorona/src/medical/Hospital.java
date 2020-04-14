package medical;

import java.util.Set;

import person.Patient;

public class Hospital extends Organization implements MedicalAction{
	
	private String hospitalId;
	private int roomTotalCount;
	private int roomEmptyCount;
	
	public Hospital() {};
	
	public Hospital(String name, int employeeCount, String hospitalId, int roomTotalCount, int roomEmptyCount) {
		super(name, employeeCount);
		this.hospitalId = hospitalId;
		this.roomTotalCount = roomTotalCount;
		this.roomEmptyCount = roomEmptyCount;
	}
	
	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public int getRoomTotalCount() {
		return roomTotalCount;
	}

	public void setRoomTotalCount(int roomTotalCount) {
		this.roomTotalCount = roomTotalCount;
	}

	public int getRoomEmptyCount() {
		return roomEmptyCount;
	}

	public void setRoomEmptyCount(int roomEmptyCount) {
		this.roomEmptyCount = roomEmptyCount;
	}
	
	public void about(String more) {
		super.about();
		System.out.println("We are Hospital" + more);
	}

	@Override
	public void addPatient(CDC cdc, Patient p) throws NotCoronaException{
		if(!p.isCorona()) throw new NotCoronaException("NotCorona");
		//cdc.getPatientList().add(p);
		cdc.addPatient(p);
	}

	@Override
	public void removePatient(CDC cdc, Patient p) {
		cdc.removePatient(p);
	}

	@Override
	public void writeReport(Set<Patient> pList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "hospitalId=" + hospitalId + ", roomTotalCount=" + roomTotalCount + ", roomEmptyCount="
				+ roomEmptyCount;
	}
	
	
}
