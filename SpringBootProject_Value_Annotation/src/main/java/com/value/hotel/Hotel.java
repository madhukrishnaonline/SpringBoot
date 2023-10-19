package com.value.hotel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class Hotel 
{
	@Value("1234")
	private String hotelId;
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${hotel.address}")
	private String hotelAddress;
	@Value("${hotel.contact}")
	private String hotelContact;
	
	@Value("#{menu.puriPrice+menu.idlyPrice}")
	private float billAmount;
	
	@Value("${customer.name}")
	private String customerName;
	
	@Value("${os.name}")
	private String osName;
	@Value("${os.version}")
	private String osVersion;
	@Value("${os.arch}")
	private String osArchitecture;
	
	
	@Value("${user.name}")
	private String userName;
	@Value("${user.dir}")
	private String userDirectory;
	
	@Value("${java.version}")
	private String javaVersion;
	@Value("${java.vendor}")
	private String javaVendor;
	@Value("${java.vendor.url}")
	private String javaVendorUrl;


	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", hotelContact=" + hotelContact + ", billAmount=" + billAmount + ", customerName=" + customerName
				+ ", osName=" + osName + ", osVersion=" + osVersion + ", osArchitecture=" + osArchitecture
				+ ", userName=" + userName + ", userDirectory=" + userDirectory + ", javaVersion=" + javaVersion
				+ ", javaVendor=" + javaVendor + ", javaVendorUrl=" + javaVendorUrl + "]";
	}
	
	
}//class
