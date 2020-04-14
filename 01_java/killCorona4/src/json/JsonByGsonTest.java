package json;

import com.google.gson.Gson;

public class JsonByGsonTest {
	public static void main(String[] args) {
		
		//object
		{
			Gson gson = new Gson();
			String jsonStr = "{'name':'Hong','age': 25}";
			Member member = gson.fromJson(jsonStr, Member.class);
			System.out.println(member.name + " " + member.age);
		}
		System.out.println();
		
		//array
		{
			Gson gson = new Gson();
			String jsonArrayStr = "[{'name':'Hong','age': 25},"
					+ " {'name':'kim','age': 26},"
					+ " {'name':'Park','age': 31}]";
			Member[] memberArray = gson.fromJson(jsonArrayStr, Member[].class);
			for (Member m : memberArray) {
				System.out.println(m.name + " " + m.age);
			}
		}
		System.out.println();
		
		// #2 java --> json
		
		//object
		{
			Gson gson = new Gson();
			Member member = new Member("kang", 29);
			String jsonStr = gson.toJson(member);
			System.out.println(jsonStr);
		}
		System.out.println();
		
		//array
		{
			Gson gson = new Gson();
			
			Member[] memberArray = {new Member("Lee", 30), new Member("Boo", 31)};
			String jsonArrayStr = gson.toJson(memberArray);
			System.out.println(jsonArrayStr);
		}
	}
}
class Member{
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
}