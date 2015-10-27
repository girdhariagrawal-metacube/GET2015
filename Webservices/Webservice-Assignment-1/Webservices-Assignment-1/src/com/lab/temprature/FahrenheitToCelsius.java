package com.lab.temprature;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FahrenheitToCelsius {

	@WebMethod
	public double tempratureConverter(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
}
