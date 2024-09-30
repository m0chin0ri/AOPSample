package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TargetService {
	public void seyHello(String name) {
		System.out.println("ハロー"  + name + "!");
	}
	
	public void seyGoobye(String name) {
		System.out.println("グッバイ"  + name + "!");
	}
}
