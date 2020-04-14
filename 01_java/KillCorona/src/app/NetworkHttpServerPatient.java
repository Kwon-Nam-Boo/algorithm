package app;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import person.Patient;

public class NetworkHttpServerPatient {

	public static void main(String[] args) {
		Patient p1 = new Patient("김동준", 33, "010-3333-3333", "고열", "001", true); 
		Patient p2 = new Patient("이순신", 35, "010-2222-2222", "감기", "101", false); 
		
		List<Patient> patientList = new ArrayList<Patient>();
		patientList.add(p1);
		patientList.add(p2);
	
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body><h2>환자 정보</h2><table style='border: 1px solid green;'>");
		for (Patient p: patientList) {
			sb.append("<tr style='border: 1px solid green;'><td>")
			.append(p.getName().substring(0,1) + "XX")
			.append("</td><td>")
			.append(p.getAge())
			.append("</td><td>")
			.append(p.getPhone().substring(0,9)+"XXXX")
			.append("</td><td>")
			.append(p.getDiseaseName())
			.append("</td><td>")
			.append(p.getHospitalId())
			.append("</td><td>")
			.append("코로나: " + String.valueOf(p.isCorona()))
			.append("</td></tr>");
			
		}
		sb.append("</table></body></html>");
		String html = sb.toString();
		
		try(ServerSocket ss = new ServerSocket(8090)){
			System.out.println("[Patient Info Server is ready]");
			
			while(true) {
				try(Socket socket = ss.accept()){
					
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
					bw.write("HTTP/1.1 200 OK \r\n");
					bw.write("Content-Type: text/html;charset=utf-8\r\n");
					bw.write("Content-Length: " + html.length() + "\r\n");
					bw.write("\r\n");
					bw.write(html);
					bw.write("\r\n");
					bw.flush();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
