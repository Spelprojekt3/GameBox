package model;


public enum Enum{	


	
AI("O"),HUMAN("X"),SIZE(4),TICTACTOE(1),SLIDEPUZZLE(2); 

private String string;
private int value;

Enum(String string){
	
	this.string=string; 	
}

Enum(int value){
	this.value=value;
}

public int value(){
	return value; 	
}
	
public String string(){
	return string;
}

}


