/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes;

import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class heroe {
    private String nombre;
	private String alias;
	private int id;
	private String casa;
	private String color;
	
	public heroe(){
            
        }
	
	
	public heroe(String alias, String nombre, int id, String casa, String color) {
		super();
		this.nombre = nombre;
		this.alias = alias;
		this.id = id;
		this.casa = casa;
		this.color = color;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public ArrayList superHeroes() {
		ArrayList heroe = new ArrayList();
		
		heroe h1 = new heroe("Batman","Bruce Wayne",1,"DC","Negro");
               
		heroe.add(h1);
		heroe h2 = new heroe("Flash","Barry allen",2,"DC","Rojo");
                
		heroe.add(h2);
		heroe h3 = new heroe("The Punisher","Frank Castle",3,"Marvel","Negro");
                
		heroe.add(h3);
                for (int i = 0; i < heroe.size(); i++) {
                    System.out.println(heroe.get(i));
                
            }
               
		return heroe;
	}
        /*
        public ArrayList getMarvel(ArrayList <heroes>heroes){
            ArrayList marvel = new ArrayList();
            
          for (int i = 0; i < heroes.size(); i++) {
              
              if(heroes.get(i).getCasa().equalsIgnoreCase("marvel"));
              
                heroes h1 = new heroes(heroes.get(i).getAlias(),heroes.get(i).getNombre(),1,heroes.get(i).getCasa(),heroes.get(i).getColor());
                marvel.add(h1);
          }
            return marvel;
        }
        
        public ArrayList getDc(ArrayList <heroes>heroes){
            ArrayList dc = new ArrayList();
            for (int i = 0; i < heroes.size(); i++) {
              
              if(heroes.get(i).getCasa().equalsIgnoreCase("dc"));
              
                heroes h1 = new heroes(heroes.get(i).getAlias(),heroes.get(i).getNombre(),1,heroes.get(i).getCasa(),heroes.get(i).getColor());
                dc.add(h1);
          }
            return dc;
        }*/
}
