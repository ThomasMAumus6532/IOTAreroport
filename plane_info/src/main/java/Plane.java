package main.java;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Random;

public class Plane {
    private int idPlane;
    private String model;
    private String brand;
    private final static String QUEUE_NAME = "hello";

    public Plane(int idPlane, String model, String brand) {
        this.idPlane = idPlane;
       
        this.model = model;
        this.brand = brand;
    }
    public boolean vol() {
    	Random rand = new Random();
        int max = 2;
        boolean isFlying;
        int int_random = rand.nextInt(max); 
        if (int_random == 0) 
        	isFlying = false;
        else 
        	isFlying = true;
        
        return isFlying;
    }
    public int getIdPlane() {
        return this.idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }


    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Plane plane1= new Plane( 152630 ,"720","boeing");
		
		if(plane1.vol()==true){
			try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
				channel.queueDeclare(QUEUE_NAME, false, false, false, null);
				String message = " the plane : "+ plane1.getIdPlane()+" is flying ";
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
				System.out.println(" [x] Sent '" + message + "'");
			}
		
		}
		else {
		
		
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = " the plane : "+ plane1.getIdPlane()+" is not flying ";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
			System.out.println(" [x] Sent '" + message + "'");
		}
	}
		}

}

