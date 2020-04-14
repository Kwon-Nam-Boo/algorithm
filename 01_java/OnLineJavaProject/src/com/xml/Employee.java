package com.xml;

public class Employee {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String role;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
		builder.append("Employee [ID=");
		builder.append(id);
		builder.append(", Name=");
		builder.append(name);
		builder.append(", Age=");
		builder.append(age);
		builder.append(", Gender=");
		builder.append(gender);
		builder.append(", Role=");
		builder.append(role + "]");
		return builder.toString();
    }
    
}
