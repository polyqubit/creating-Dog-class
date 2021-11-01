import java.util.Random;
import java.util.Scanner;
public class Dog {
  private String name,breed,tA,tB,gender = "null";
  private int age,genome = 1;
  public String g1,g2 = "null";
  public double stamina = 255; //full is 255
  public double hunger = 255; //full is 255
  public double friendship = 0; //max is 255
  private boolean genomeInitialized = false;
  private Random rand = new Random();
  public float[] multipliers = {1,1,1,1,1,1};
  public boolean[] skills = {false,false,false,false,false,false};
  private Scanner sc = new Scanner(System.in);
  /**
    GENE description(starting from least sig):
    breed/species
    trait(described bottom of file)
    secondary trait
    gender
  **/
  /**
    SKILLS are stored in arrays, which are:
    0 - fetch
    1 - barrel roll
    2 - stand
    3 - jump
    4 - tug of war
    5 - high five(paw)
    6 - idk man i just want to go to sleep
    7 - 
    8 - 
    9 - 
    A - 
    B - 
    C - 
    D - 
    E - 
    F - 
  **/
  /**
	ACTIVITIES are:
	0 - nothing
	1 - sleeping
	2 - eating
	3 - play
	4 - teach
	5 - 
	6 - 
	7 - 
	8 - 
	9 - 
	A - 
	B - 
	C - 
	D - 
	E - 
	F - 
  **/
  /**
	MULTIPLIER array:
	0 - friendship gain
	1 - hunger gain
	2 - stamina gain
	3 - reps
	4 - competitive bonus
	5 - activity bonus
  **/
  public Dog() {
    name = new String("Clifford");
    age = 3;
    genome = 0x0100;
  }
  public Dog(String name) {
    this.name = name;
    age = 0;
    genome = 0x0100;
  }
  public Dog(String name, int age) {
    this.name = name;
    this.age = age;
    genome = 0x0000;
  }
  public Dog(int age) {
    name = new String("Clifford II");
    this.age = age;
    genome = 0x0000;
  }
  public void setGenome() {
    genome = rand.nextInt(65536);
    genomeInitialized = true;
	  updateGenome();
  }
  public void editGenome(int genome) {
      this.genome = genome;
	  genomeInitialized = true;
	  updateGenome();
  }
  public int readGenome(boolean print) {
    if(genomeInitialized&&print) {
      System.out.println(String.format("0x%08X", genome));
      return genome;
    }
    else if(genomeInitialized) {
      return genome;
    }
    else {return 0;}
  }
  public void updateGenome() {
	int a = nibbleExtract(genome, 1);
	int b = nibbleExtract(genome, 2);
	int c = nibbleExtract(genome, 3);
	int d = nibbleExtract(genome, 4);
	for(int i=0;i<multipliers.length;i++) {multipliers[i]=1;}
	//System.out.println(a+", "+b+", "+c+", "+d);
    switch(a) {
		case 0: breed = new String("German Shepherd"); break;
		case 1: breed = new String("Pomeranian"); break;
		case 2: breed = new String("Pug"); break;
		case 3: breed = new String("Golden Retriever"); break;
		case 4: breed = new String("Shiba Inu"); break;
		case 5: breed = new String("Poodle"); break;
		case 6: breed = new String("Dachshund"); break;
		case 7: breed = new String("Bulldog"); break;
		case 8: breed = new String("Dalmatian"); break;
		case 9: breed = new String("Tibetan Mastiff"); break;
		case 10: breed = new String("Corgi"); break;
		case 11: breed = new String("Beagle"); break;
		case 12: breed = new String("Collie"); break;
		case 13: breed = new String("Great Pyrenees"); break;
		case 14: breed = new String("Shetland Sheepdog"); break;
		case 15: breed = new String("Alaskan Malamute"); break;
		default: breed = new String("Dog"); break;
	}
	switch(b) {
		case 0: case 1: case 10: tA = new String("Competitive"); multipliers[4]*=1.5; multipliers[3]*=0.5; break;
		case 2: case 3: case 11: tA = new String("Gluttonous"); multipliers[1]*=2; break;
		case 4: case 5: case 12: tA = new String("Stubborn"); multipliers[3]*=1.5; break;
		case 6: case 7: case 13: tA = new String("Sweaty"); break;
		case 8: case 9: case 14: tA = new String("Smart"); multipliers[4]*=1.5; break;
		default: tA = new String("Competitive"); multipliers[4]*=1.5; multipliers[3]*=0.5; break;
	}
	switch(c) {
		case 0: case 1: case 10: tB = new String("Friendly"); multipliers[0]*=2; break;
		case 2: case 3: case 11: tB = new String("Aggressive"); multipliers[0]*=0.5; break;
		case 4: case 5: case 12: tB = new String("Hyperactive"); multipliers[1]*=1.5; multipliers[5]*=2; break;
		case 6: case 7: case 13: tB = new String("Muscular"); multipliers[2]*=1.5; multipliers[5]*=1.5; break;
		case 8: case 9: case 14: tB = new String("Lazy"); multipliers[2]*=0.75; multipliers[5]*=0.5; break;
		default: tB = new String("Friendly"); break;
	}
	if((d%2)==0) {gender = new String("Male"); g1 = new String("him"); g2 = new String("he");}
	else {gender = new String("Female"); g1 = new String("her"); g2 = new String("she");}
  }
  public String readStat(int inp) {
    switch(inp) {
      case 0: return name;
      case 1: return breed;
      case 2: return tA;
      case 3: return tB;
      case 4: return gender;
      default: return "null";
    }
  }
  public int readAge() {
    return age;
  }
  public void rename(String name) {
    this.name = name;
  }
  private int nibbleExtract(int inp, int digit) {
    int bit = inp >> (digit-1)*4;
    return bit & 0x000F;
    //return bit;
  }
  public int readStamina() {
	return (int)stamina;
  }
  public int readHunger() {
	return (int)hunger;  
  }
  public int readFriendship() {
	return (int)friendship;
  }
  public void teachSkill(String inp) {
	  boolean learned = false;
	  int check = 0;
	  switch(inp) {
		case "fetch":
			if(!skills[0]){
				System.out.println("Throw a ball by pressing enter. After enough tries "+name+" will successfully return the ball.");
				while(!learned) {
					sc.nextLine();
					System.out.println("\nWoof?");
					check = rand.nextInt((int)(20*multipliers[3]));
					if(check==0) {
						System.out.println("Woof!\n"+name+" returns the ball.");
						learned = true;
						skills[0] = true;
					}
				}
			}else{System.out.println(name+" has already learned this trick.");}
		break;
		case "barrel roll":
			if(!skills[1]) {
				System.out.println("Roll on the ground by pressing enter. After enough tries "+name+" will successfully roll over.");
				while(!learned) {
					sc.nextLine();
					System.out.println("\nWoof?");
					check = rand.nextInt((int)(20*multipliers[3]));
					if(check==0) {
						System.out.println("Woof!\n"+name+" rolls over.");
						learned = true;
						skills[1] = true;
					}
				}
			}else{System.out.println(name+" has already learned this trick.");}
		break;
		case "stand":
			if(!skills[2]) {
				System.out.println("You are seated on the ground. To stand up, press enter, then press enter again to sit down. After enough tries "+name+" will successfully stand up.");
				while(!learned) {
					sc.nextLine();
					System.out.println("\nWoof?");
					sc.nextLine();
					System.out.println("\nArf?");
					check = rand.nextInt((int)(20*multipliers[3]));
					if(check==0) {
						System.out.println("Woof!\n"+name+" stands up.");
						learned = true;
						skills[2] = true;
					}
				}
			}else{System.out.println(name+" has already learned this trick.");}
		break;
		case "jump":
			if(!skills[3]) {
				System.out.println("Jump by pressing enter. After enough tries "+name+" will successfully jump.");
				while(!learned) {
					sc.nextLine();
					System.out.println("\nRrf?");
					check = rand.nextInt((int)(20*multipliers[3]));
					if(check==0) {
						System.out.println("Woof!\n"+name+" jumps.");
						learned = true;
						skills[3] = true;
					}
				}
			}else{System.out.println(name+" has already learned this trick.");}
		break;
		case "high five":
			if(!skills[4]) {
				System.out.println("Touch "+name+"'s paw to your hand by pressing enter. After enough tries "+name+" will successfully give you a high five.");
				while(!learned) {
					sc.nextLine();
					System.out.println("\nWoof?");
					check = rand.nextInt((int)(20*multipliers[3]));
					if(check==0) {
						System.out.println("Woof!\n"+name+" bats your hand.");
						learned = true;
						skills[4] = true;
					}
				}
			}else{System.out.println(name+" has already learned this trick.");}
		break;
		case "tug of war":
			if(!skills[5]) {
				System.out.println("You place a rope in front of "+name+". Press enter to tug at the rope. After enough tries "+name+" will tug the rope back.");
				while(!learned) {
					sc.nextLine();
					System.out.println("\nRuff?");
					check = rand.nextInt((int)(20*multipliers[3]));
					if(check==0) {
						System.out.println("Arrf!\n"+name+" yanks the rope from your hand.");
						learned = true;
						skills[5] = true;
					}
				}
			}else{System.out.println(name+" has already learned this trick.");}
		break;
	  }
  }
  public void play(String inp) {
	  int randomEvent = rand.nextInt(3);
	  switch(inp) {
		  case "fetch":
			if(skills[0]) {
				System.out.println("Press enter to throw a ball.");
				sc.nextLine();
				switch(randomEvent) {
					case 0:
						System.out.println(name+" returns the ball.");
					break;
					case 1:
						System.out.println(name+" returns two balls. Where did this one come from?");
					break;
					case 2:
						System.out.println(name+" brings back a stick. You spend some time throwing this instead");
					break;
				}
				stamina -= 3;
				hunger -= 3;
			}else{System.out.println(name+" has not learned this yet.");}
		  break;
		  case "barrel roll":
			if(skills[1]) {
				System.out.println("Press enter to have "+name+" roll over.");
				switch(randomEvent) {
					case 0:
						System.out.println(name+" rolls over.");
					break;
					case 1:
						System.out.println(name+" does a backflip. When did "+g2+" learn that?");
					break;
					case 2:
						System.out.println(name+" does a barrel roll. And another. And another. Before long you are rolling too.");
					break;
				}
				stamina -= 1;
				hunger -= 1;
			}else{System.out.println(name+" has not learned this yet.");}
		  break;
		  case "stand":
			if(skills[2]) {
				System.out.println("Press enter to raise your hand.");
				switch(randomEvent) {
					case 0:
						System.out.println(name+" stands up at your cue.");
					break;
					case 1:
						System.out.println(name+" stands up and walks away. "+g2+"'s surpassed caninehood.");
					break;
					case 2:
						System.out.println(name+" stands up and shakes your hand. Unknowingly you have agreed to transfer your assets to "+name+"'s company.");
					break;
				}
				stamina -= 1;
				hunger -= 1;
			}else{System.out.println(name+" has not learned this yet.");}
		  break;
		  case "jump":
			if(skills[3]) {
				System.out.println("Press enter to jump.");
				switch(randomEvent) {
					case 0:
						System.out.println(name+" jumps with you.");
					break;
					case 1:
						System.out.println(name+" jumps but does not fall back down. You stare awkwardly at the levitating dog.");
					break;
					case 2:
						System.out.println(name+" jumps onto your back. You are wrestled to the ground.");
					break;
				}
				stamina -= 2;
				hunger -= 2;
			}else{System.out.println(name+" has not learned this yet.");}
		  break;
		  case "high five":
			if(skills[5]) {
				System.out.println("Press enter to put out your hand.");
				switch(randomEvent) {
					case 0:
						System.out.println(name+" gives you a high five!");
					break;
					case 1:
						System.out.println(name+" mistakes your action as a arm wrestle challenge and forces your hand to the ground.");
					break;
					case 2:
						System.out.println(name+" bites your hand, thinking you meant to offer "+g1+" a treat.");
					break;
				}
				stamina -= 1;
				hunger -= 1;
			}else{System.out.println(name+" has not learned this yet.");}
		  break;
		  case "tug of war":
			if(skills[6]) {
				System.out.println("Press enter to place a rope in front of "+name+".");
				switch(randomEvent) {
					case 0:
					break;
					case 1:
					break;
					case 2:
					break;
				}
				stamina -= 3;
				hunger -= 3;
			}else{System.out.println(name+" has not learned this yet.");}
		  break;
	  }
  }
  public void summary() {
    if(genomeInitialized){
		System.out.println("Your dog, \""+name+"\" is "+tA+", "+tB+" and "+gender+". ");
		System.out.println("Your dog is "+age+" years old and is a "+breed);
    }
  }
  //unused methods
  public void bark() {System.out.println(name+ "barks!");}
  public boolean isSleeping() {return rand.nextBoolean();}
}

/**
0 - competitive, takes 0.5x as many repetitions to teach a trick and gains 1.5x more friendship from activities if another dog is present
1 - friendly, gains friendship 2x faster from all sources
2 - glutton, hunger gain 2x faster
3 - aggressive, gains friendship 0.5x as fast
4 - stubborn, takes 1.5x as many repetitions to teach a trick
5 - hyperactive, gains 2x friendship from activities, hunger gain 1.5x faster
6 - sweaty, just sweats a lot lol
7 - muscular, 1.5x stamina, 1.5x friendship from activities
8 - smart, takes 0.5x as many repetitions to teach a trick
9 - lazy, gains 0.5x as much friendship from activities, 0.75x stamina
**/
