package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import medical.CDC;
import medical.Hospital;
import medical.NotCoronaException;
import person.Patient;

public class MainTest {
	public static void main(String[] args) {
		
		Hospital univHospital = new Hospital("대학병원", 15, "001", 50, 10);
		Hospital localHospital = new Hospital("동네병원", 3, "901", 10, 2);
		
		Patient p1 = new Patient("환자", 42, "010-1111-1111", "호흡곤란", "001", true);
		Patient p2 = new Patient("환자2", 30, "010-2222-2222", "과음", "901", false);
		//Patient p3 = new Patient("환자2", 30, "010-2222-2222", "과음", "901", false);
		
		// 병원 Collection
		 List<Hospital> hospitalList = new ArrayList<Hospital>();
		 hospitalList.add(univHospital);
		 hospitalList.add(localHospital);
		 
		 // 환자 Collection
		 Set<Patient> patientList = new HashSet<>();
		 patientList.add(p1);
		 patientList.add(p2);
		 
		 //MedicalAction Test
		 
		 // Overriding Test
		CDC cdc = new CDC("질병관리본부", 200, hospitalList, patientList);
		
		Patient p3 = new Patient("환자3", 33, "010-3333-3333", "고열", "001", true);
		try {
			univHospital.addPatient(cdc, p3);
		} catch (NotCoronaException e) {
			System.out.println("corona 환자가 아닙니다");
			//System.out.println(e);
		}
		System.out.println(cdc.getPatientList());
		
		univHospital.removePatient(cdc, p3);
		System.out.println(cdc.getPatientList());
		
		
		//File Write 
		//String filePath = "c:"+File.separator+"SSAFY";	// 밑과 같다
		String filePath = "c:\\SSAFY";	//
		//System.out.println(File.separator);
		//String fileName = "CoronaPatientList.csv";
		String fileName = "c:\\SSAFY\\CoronaPatientList.csv";
		
		try(
			//BufferedWriter writer = new BufferedWriter(new FileWriter(filePath+File.separator+fileName));
			BufferedWriter writer = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(fileName), "MS949"));
				
		){
			for (Patient p : patientList) {
				writer.write(p.getName() + "," + p.getAge() + ","+ p.getPhone());
				writer.newLine();
			}
			writer.flush(); // 강제출력
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
