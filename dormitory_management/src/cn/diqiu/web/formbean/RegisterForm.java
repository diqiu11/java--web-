package cn.diqiu.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String nickname;
	private String room;
	private Map errors = new HashMap();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}

	public boolean validate(){//formbean就是为了验证而出现的
		boolean isOK = true;
		if(this.username==null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "用户名不能为空！");
		}else{
			if(!this.username.matches("[A-Za-z]{3-10}")){
				isOK = false;
				errors.put("username", "用户名为3-10位字母！");
			}
		}
		
		if(this.password==null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "密码不能为空！");
		}else{
			if(!this.password.matches("\\d{3-10}")){
				isOK = false;
				errors.put("password", "密码为3-10位数字和字母！");
			}
		}
		if(this.password2==null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password2", "密码不能为空！");
		}else{
			if(this.password2!=this.password){
				isOK = false;
				errors.put("password2", "前后密码要一致");
			}
		}
		if(this.nickname==null || this.nickname.trim().equals("")){
			isOK = false;
			errors.put("nickname", "昵称不能为空！");
		}else{
			if(!this.nickname.matches("^([\u4e00-\u99fa5]+)$")){//^([\u4e00-\u99fa5]+)$
				isOK = false;
				errors.put("nickname", "昵称必须为汉字！");
			}
		}
		if(this.room==null || this.room.trim().equals("")){
			isOK = false;
			errors.put("room", "宿舍不能为空！");
		}else{
			if(!this.room.matches("\\d{1-2}+-+\\d{3}")){//\\d{1-2}+-+\\d{3}
				isOK = false;
				errors.put("room", "宿舍格式有误！");
			}
		}
		
		return isOK;
	}
	
	
}
