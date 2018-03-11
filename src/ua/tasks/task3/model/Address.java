package ua.tasks.task3.model;

/**
 * Class describes an information about address
 *
 * @autor Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class Address {
    private Integer index;
    private String city;
    private String street;
    private String houseNumber;
    private Integer apartmentNumber;

    /**
     * Process getting full address in line
     *
     * @return string presentation
     */
    public String getFullAddress() {
        StringBuilder sb = new StringBuilder();
        sb.append(index).append(" ");
        sb.append(city).append(" ");
        sb.append(street).append(" ");
        sb.append(houseNumber).append(" ");
        sb.append(apartmentNumber);
        return new String(sb);
    }

    public Integer getIndex() {
        return index;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("index=").append(index);
        sb.append(", city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", houseNumber='").append(houseNumber).append('\'');
        sb.append(", apartmentNumber=").append(apartmentNumber);
        sb.append('}');
        return sb.toString();
    }
}
