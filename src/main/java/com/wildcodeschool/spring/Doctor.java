package com.wildcodeschool.spring;

import com.fasterxml.jackson.databind.JsonNode;

public class Doctor {
	
		//attributs
		int number;
		String name;
		
		//constructeur
		public Doctor(int number, String name) {
			this.number = number;
			this.name = name;
		}
		
		//getters
		public int getNumber() {
			return this.number;
		}
		
		public String getName() {
			return this.name;
		}
}
