package com.spring.entity;

public class HeroAttrsEntity {
	private int id;
	private int survival;
	private int damage;
	private int skill;
	private int difficulty;
	private String passive;
	private String first;
	private String second;
	private String  third;
	private int heroId;
	private String firstName;
	private String secondName;
	private String thirdName;
	private String passiveName;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getSurvival(){
		return this.survival;
	}
	
	public void setSurvival(int survival){
		this.survival = survival;
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public void setDamage(int damage){
		this.damage = damage;
	}
	
	public int getSkill(){
		return this.skill;
	}

	public void setSkill(int skill){
		this.skill = skill;
	}
	
	public int getDifficulty(){
		return this.difficulty;
	}
	
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
	
	public String getPassive(){
		return this.passive;
	}
	
	public void setPassive(String passive){
		this.passive = passive;
	}
	
	public String getFirst(){
		return this.first;
	}
	
	public void setFirst(String first){
		this.first = first;
	}
	
	public String getSecond(){
		return this.second;
	}
	
	public void setSecond(String second){
		this.second = second;
	}
	
	public String getThird(){
		return this.third;
	}
	
	public void setThird(String third){
		this.third = third;
	}
	
	public int getHeroId(){
		return this.heroId;
	}
	
	public void setHeroId(int heroId){
		this.heroId = heroId;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getSecondName(){
		return this.secondName;
	}
	
	public void setSecondName(String secondName){
		this.secondName  = secondName;
	}
	
	public String getThirdName(){
		return this.thirdName;
	}
	
	public void setThirdName(String thirdName){
		this.thirdName  = thirdName;
	}
	
	public String getPassiveName(){
		return this.passiveName;
	}
	
	public void setPassiveName(String passiveName){
		this.passiveName  = passiveName;
	}
	
}
