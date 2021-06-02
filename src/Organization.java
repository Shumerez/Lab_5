
import java.time.*;

/**
 * Class of all objects in our ArrayList
 */
public class Organization {
    private Integer id; //���� �� ����� ���� null, �������� ���� ������ ���� ������ 0, �������� ����� ���� ������ ���� ����������, �������� ����� ���� ������ �������������� �������������
    private String name; //���� �� ����� ���� null, ������ �� ����� ���� ������
    private Coordinates coordinates; //���� �� ����� ���� null
    private LocalDateTime creationDate; //���� �� ����� ���� null, �������� ����� ���� ������ �������������� �������������
    private Integer annualTurnover; //���� �� ����� ���� null, �������� ���� ������ ���� ������ 0
    private OrganizationType type; //���� �� ����� ���� null
    private Address postalAddress; //���� �� ����� ���� null

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
