
import java.time.*;

/**
 * Class of all objects in our ArrayList
 */
public class Organization {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null
    private Address postalAddress; //Поле не может быть null

    public Organization(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, Integer annualTurnover, OrganizationType type, Address postalAddress) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.postalAddress = postalAddress;
    }
    
    public Integer getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public Coordinates getCoordinates()
    {
        return coordinates;
    }
    public LocalDateTime getCreationDate()
    {
        return creationDate;
    }
    public Integer getAnnualTurnover()
    {
        return annualTurnover;
    }
    public OrganizationType getType()
    {
        return type;
    }
    public Address getPostalAddress()
    {
        return postalAddress;
    }
    
    public void setId(Integer newId)
    {
        this.id = newId;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }
    public void setCoordinates(Coordinates newCoordinates)
    {
        this.coordinates = newCoordinates;
    }
    public void setCreationDate(LocalDateTime newCreationDate)
    {
        this.creationDate = newCreationDate;
    }
    public void setAnnualTurnover(Integer newAnnualTurnover)
    {
        this.annualTurnover = newAnnualTurnover;
    }
    public void setType(OrganizationType newType)
    {
        this.type = newType;
    }
    public void setAddress(Address newPostalAddress)
    {
        this.postalAddress = newPostalAddress;
    }
    
    @Override
    public String toString() {
        return ("id:"+this.id +
                    "Name: "+ this.name +
                    "Coordinates: "+ this.coordinates +
                    "Creation date : " + this.creationDate +
                    "Annual turnover : " + this.annualTurnover +
                    "Type : " + this.type +
                    "Address : " + this.postalAddress);
    }
}
