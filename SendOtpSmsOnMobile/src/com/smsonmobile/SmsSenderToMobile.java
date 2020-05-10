package com.smsonmobile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.SplittableRandom;

/**
 * @author Vinod.nagulkar
 *
 */
public class SmsSenderToMobile 
{
	public static String generateOtp(int otpLength)
	{
		SplittableRandom splittableRandom=new SplittableRandom();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < otpLength; i++) 
		{
			sb.append(splittableRandom.nextInt(0, 10));
		}
		return sb.toString();
	}

	public static void sendOtpSms(String otp)
	{
		String apiKey = "apiKey=" + "paste Apikey here"; //In this double quote paste api key. 
										//Goto www.textlocal.in and create your account then login and 
										//generate apikey from that sms provider website.
		
		try {
			String message = "&message=" + URLEncoder.encode("Your OTP is "+ otp,"UTF-8");
			
			
			String mobileNumbers = "&mobileNumbers=" + "12345678990,1234567890"; //You can send message to multiple numbers by giving (,)
			
			String apiURL = "https://api.textlocal.in/send/?" + apiKey + message + mobileNumbers;
			
			URL url=new URL(apiURL);
			
			URLConnection connection = url.openConnection();
			
			connection.setDoOutput(true);
			
			BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			System.out.println(reader.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String otp=SmsSenderToMobile.generateOtp(5);
		sendOtpSms(otp);
		System.out.println(otp);
		
	}

	
	
}
