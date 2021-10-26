import java.util.Random;
public class Dog {
  private String name,breed,tA,tB;
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
    genome = 0x0000;
  }
  public Dog(String name, int age) {
    this.name = name;
    this.age = age;
    genome = 0x0000;
  }
  public void setGenome() {
    genome = rand.nextInt(65536);
    genomeInitialized = true;
	int a = nibbleExtract(genome, 1);
	int b = nibbleExtract(genome, 2);
	int c = nibbleExtract(genome, 3);
	int d = nibbleExtract(genome, 4);
    switch(a) {
		case 0: breed = new String("German Shepherd");
		case 1: breed = new String("Pomeranian");
		case 2: breed = new String("Pug");
		case 3: breed = new String("Golden Retriever");
		case 4: breed = new String("Shiba Inu");
		case 5: breed = new String("Poodle");
		case 6: breed = new String("Dachshund");
		case 7: breed = new String("Bulldog");
		case 8: breed = new String("Dalmatian");
		case 9: breed = new String("Tibetan Mastiff");
		case 10: breed = new String("Corgi");
		case 11: breed = new String("Beagle");
		case 12: breed = new String("Collie");
		case 13: breed = new String("Great Pyrenees");
		case 14: breed = new String("Shetland Sheepdog");
		case 15: breed = new String("Alaskan Mamalute");
	}
  }
  public void editGenome(int genome) {
    if(genomeInitialized){
      this.genome = genome;
    }
  }
  public void readGenome() {
    if(genomeInitialized){
      System.out.println(String.format("0x%08X", genome));
    }
  }
  public void rename(String name) {
    this.name = name;
  }
  public int nibbleExtract(int inp, int digit) {
    int bit = inp >> (digit-1)*4;
    return bit & 0x000F;
    //return bit;
  }
  public void summary() {
    //NOOO I DONT WANT TO DO 500 SWITCH STATEMENTS
    //oh well
    if(genomeInitialized){
      int b = nibbleExtract(genome, 1);
      switch(breed) {case}
      System.out.println("w");
    }
  }
}

/**
0 - competititve, takes 0.5x as many repetitions to teach a trick and gains 1.5x more friendship from activities if another dog is present
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