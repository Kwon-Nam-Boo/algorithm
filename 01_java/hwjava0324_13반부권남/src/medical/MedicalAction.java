package medical;

import java.util.Set;
import person.Patient;

public interface MedicalAction {
	void addPatient(CDC cdc,Patient p) throws NotCoronaException;
	void removePatient(CDC cdc ,Patient p);
	void writeReport(Set<Patient> pList);
	
	default int getPatientNum() { // java 8
		return 1;
	}
}
