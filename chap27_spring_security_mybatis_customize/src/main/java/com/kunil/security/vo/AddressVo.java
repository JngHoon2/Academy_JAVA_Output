package com.kunil.security.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString	//(exclude={"제외할 값"})
public class AddressVo {
	private String zip_num;
	private String sido;
	private String gugun;
	private String dong;
	private String zip_code;
	private String bunji;

	/*
	public AddressVo() {

	}
	
	public String getZip_num() {
		return zip_num;
	}

	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}

	@Override
	public String toString() {
		return "AddressVo [zip_num=" + zip_num + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong
				+ ", zip_code=" + zip_code + ", bunji=" + bunji + "]";
	}
	*/
}
