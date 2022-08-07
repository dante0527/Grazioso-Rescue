public class Monkey extends RescueAnimal {
    
    // Instance variables
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;

    // Constructors
    public Monkey() {
    }

    public Monkey(String name, String species, String gender, String age,
                    String weight, String acquisitionDate, String acquisitionCountry,
	                String trainingStatus, boolean reserved, String inServiceCountry, 
                    String tailLength, String height, String bodyLength) {
        
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
    }

    // Accessor Methods
    public String getTailLength() {
        return tailLength;
    }

    public String getHeight() {
        return height;
    }

    public String getBodyLength() {
        return bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    // Mutator Methods
    public void setTailLength(String length) {
        tailLength = length;
    }

    public void setHeight(String userHeight) {
        height = userHeight;
    }

    public void setBodyLength(String userBodyLength) {
        bodyLength = userBodyLength;
    }

    public void setSpecies(String userSpecies) {
        species = userSpecies;
    }

}
