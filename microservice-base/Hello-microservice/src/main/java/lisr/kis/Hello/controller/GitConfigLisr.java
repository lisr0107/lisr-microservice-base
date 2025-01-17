package lisr.kis.Hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
//@RefreshScope是spring cloud提供的一种特殊的scope实现，用来实现配置、实例热加载。
@RefreshScope
@Component
public class GitConfigLisr {
	@Value("${lisr.name:none}")
	private String name;
	@Value("${lisr.age:18}")
	private int age;
	@Value("${lisr.gender:boy}")
	private String gender;
	
	@Value("${lisr.password:none}")
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
