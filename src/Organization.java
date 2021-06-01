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
