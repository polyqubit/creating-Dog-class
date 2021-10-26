import java.util.Random;
public class Dog {
	private String name,breed,tA,tB,gender;
  private int age,data,genome;
  private boolean genomeInitialized = false;
  private Random rand = new Random();
  /**
    GENE description(starting from least sig):
    breed/species
    trait(described bottom of file)
    secondary trait
    gender
  **/
  /**
    DATA description(starting from least sig)
    hunger value
    friend value
    stamina
    activity
  **/
  /**
    SKILLS are stored in arrays, which are:
    0 - name recognition
    1 - 
    2 - 
    3 - 
    4 - 
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
  public void setGenome() {
    genome = rand.nextInt(65536);
    genomeInitialized = true;
	updateGenome();
  }
  public void editGenome(int genome) {
    if(genomeInitialized){
      this.genome = genome;
	  updateGenome();
    }
  }
  public void readGenome() {
    if(genomeInitialized){
      System.out.println(String.format("0x%08X", genome));
    }
  }
  public void updateGenome() {
	int a = nibbleExtract(genome, 1);
	int b = nibbleExtract(genome, 2);
	int c = nibbleExtract(genome, 3);
	int d = nibbleExtract(genome, 4);
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
		case 0: case 1: case 10: tA = new String("Competitive"); break;
		case 2: case 3: case 11: tA = new String("Gluttonous"); break;
		case 4: case 5: case 12: tA = new String("Stubborn"); break;
		case 6: case 7: case 13: tA = new String("Sweaty"); break;
		case 8: case 9: case 14: tA = new String("Smart"); break;
		default: tA = new String("Competitive"); break;
	}
	switch(c) {
		case 0: case 1: case 10: tB = new String("Friendly"); break;
		case 2: case 3: case 11: tB = new String("Aggressive"); break;
		case 4: case 5: case 12: tB = new String("Hyperactive"); break;
		case 6: case 7: case 13: tB = new String("Muscular"); break;
		case 8: case 9: case 14: tB = new String("Lazy"); break;
		default: tB = new String("Friendly"); break;
	}
	switch(d) {
		case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: gender = new String("Male"); break;
		default: gender = new String("Female"); break;
	}
  }
  public void rename(String name) {
    this.name = name;
  }
  private int nibbleExtract(int inp, int digit) {
    int bit = inp >> (digit-1)*4;
    return bit & 0x000F;
    //return bit;
  }
  public void summary() {
    if(genomeInitialized){
		System.out.println("Your dog, \""+name+"\" is "+tA+", "+tB+" and "+gender+". ");
		System.out.println("Your dog is "+age+" years old and is a "+breed);
    }
  }
}

/**
0 - competitive, takes 0.5x as many repetitions to teach a trick and gains 1.5x more friendship from activities if another dog is present
1 - friendly, gains friendship 2x faster from all sources
2 - glutton, hunger gain 2x faster
3 - aggressive, gains friendship 0.5x as fast
4 - stubborn, takes 1.5x as many repetitions to teach a trick
5 - hyperactive, gains 2x friendship from activities
6 - mrpoole, plays LoL
7 - muscular, 1.5x stamina, 1.5x friendship from activities
8 - smart, takes 0.5x as many repetitions to teach a trick
9 - lazy, gains 0.5x as much friendship from activities, 0.75x stamina
**/
