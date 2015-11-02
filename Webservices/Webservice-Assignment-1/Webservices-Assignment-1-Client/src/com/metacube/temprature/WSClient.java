package com.metacube.temprature;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.lab.temprature.FahrenheitToCelsius;
import com.lab.temprature.FahrenheitToCelsiusServiceLocator;

public class WSClient {

	public static void main(String[] args) {
		FahrenheitToCelsiusServiceLocator locator = new FahrenheitToCelsiusServiceLocator();
		locator.setFahrenheitToCelsiusEndpointAddress("http://localhost:8080/Webservices-Assignment-1/services/FahrenheitToCelsius");
			FahrenheitToCelsius object;
			try {
				object = locator.getFahrenheitToCelsius();
				System.out.println(object.tempratureConverter(20.3));
			} catch (ServiceException | RemoteException e) {
				e.printStackTrace();
			}
	}
}
