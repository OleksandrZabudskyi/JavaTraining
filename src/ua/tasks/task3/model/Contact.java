package ua.tasks.task3.model;

import java.time.LocalDate;

/**
 * Class describes an information about contact
 *
 * @autor Zabudskyi Oleksandr zabudskyioleksandr@gmail.com
 */
public class Contact {
    private String lastName;
    private String firstName;
    private String additionalName;
    private String nickName;
    private String comment;
    private Group group;
    private String homePhone;
    private String mobilePhone;
    private String additionalMobilePhone;
    private String email;
    private String skype;
    private Address address;
    private LocalDate createDate;
    private LocalDate modificationDate;

    /**
     * Getting last name with short form of second name in line
     *
     * @return string presentation
     */
    public String getLastNameWithInitials() {
        StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(" ");
        sb.append(firstName.substring(0, 1)).append(".");
        return new String(sb);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAdditionalMobilePhone() {
        return additionalMobilePhone;
    }

    public void setAdditionalMobilePhone(String additionalMobilePhone) {
        this.additionalMobilePhone = additionalMobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("lastName='").append(lastName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", additionalName='").append(additionalName).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", group=").append(group);
        sb.append(", homePhone='").append(homePhone).append('\'');
        sb.append(", mobilePhone='").append(mobilePhone).append('\'');
        sb.append(", additionalMobilePhone='").append(additionalMobilePhone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", skype='").append(skype).append('\'');
        sb.append(", address=").append(address);
        sb.append(", createDate=").append(createDate);
        sb.append(", modificationDate=").append(modificationDate);
        sb.append('}');
        return sb.toString();
    }
}