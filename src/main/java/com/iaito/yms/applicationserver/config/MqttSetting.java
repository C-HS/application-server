package com.iaito.yms.applicationserver.config;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
//import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.springframework.stereotype.Service;


public class MqttSetting implements MqttCallbackExtended {
	
	MqttClient client;
	
	public MqttSetting()
	{
		connect();
	}
	
	
	public void connect()
	{
		
		try
		{
			System.out.println("11111111111111");
		     client = new MqttClient("tcp://localhost:1883","MyApplicationServerSubscriber1");
		     System.out.println("222222222222222222222");
		     client.setCallback(this);
		     System.out.println("333333333333");
		     MqttConnectOptions mqOptions=new MqttConnectOptions();
		     
		     System.out.println("44444444444444444444");
		     mqOptions.setAutomaticReconnect(true);
		     System.out.println("555555555555555");
		     mqOptions.setCleanSession(true);
		     System.out.println("666666666666666");
		    // client.connect(mqOptions);      //connecting to broker 
		     System.out.println("77777777777777");

		    
		     if (!client.isConnected()) {
		    	 client.connect(mqOptions);
	            }
		     
		     System.out.println("88888888888888 ");
		     client.subscribe("GPSTopic"); //subscr
		     System.out.println("9999999999999 ");
		     
		     System.out.println("SSSSSSSSSSSS ");
		     
		     
		}
		catch(Exception e)
		{
			System.out.println("Exception "+e.getMessage());
		}
	}

	
	@Override
	public void connectionLost(Throwable cause) {

		try
		{
			      System.out.println("connectionLost "+client.isConnected());
			      
				     
				      //subscr
				     //client.subscribe("testtopic"); //subscr
				     System.out.println("aaaaaaaaaaaaaaaa");
		}
		catch(Exception e)
		{
			System.out.println("connectionLost Exception "+e.getMessage());
			
		}
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {

		System.out.println("messageArrived from topic "+topic+"  msg= "+message);
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		  System.out.println("deliveryComplete");
		
	}


	@Override
	public void connectComplete(boolean reconnect, String serverURI) {
		  System.out.println("connectComplete "+reconnect+" "+client.isConnected());
		  try
		  {
		  if(reconnect)
		  {
			     
			     client.subscribe("GPSTopic"); //subscr
		  }
		  }
		  catch(Exception e)
		  {
			  System.out.println("connectComplete Exception "+e.getMessage());
		  }
		  
		
	}

}
