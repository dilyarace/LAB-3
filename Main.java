class Main {
    public static void main(String[] args) {

        AnimalFeeder feeder = new SimpleAnimalFeeder();

        Zoo zoo = new Zoo();

        AnimalFoodAdapter foodAdapter = new AnimalFoodAdapter(feeder);

        Animal lion = new Lion();

        // Feed the lion in the zoo using the adapted AnimalFoodAdapter
        zoo.feedAnimal(lion, foodAdapter);
    }
}

// Interface for providing food to animals
interface AnimalFeeder {
    void provideFood();
}

// AnimalFoodAdapter adapts an AnimalFeeder to provide food
class AnimalFoodAdapter implements AnimalFeeder {
    AnimalFeeder originalFeeder;

    public AnimalFoodAdapter(AnimalFeeder originalFeeder) {
        this.originalFeeder = originalFeeder;
    }

    @Override
    public void provideFood() {
        // Use the original AnimalFeeder to provide food
        originalFeeder.provideFood();
    }
}

// Interface for animals
interface Animal {
    void eat();
}

// Lion is an example of an animal that can eat
class Lion implements Animal {
    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }
}

// SimpleAnimalFeeder provides food to animals
class SimpleAnimalFeeder implements AnimalFeeder {
    @Override
    public void provideFood() {
        System.out.println("Providing animal food");
    }
}

// Zoo manages feeding animals
class Zoo {
    public void feedAnimal(Animal animal, AnimalFeeder feeder) {
        // Provide food to the animal
        feeder.provideFood();

        // The animal eats
        animal.eat();
    }
}
