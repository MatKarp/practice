package pl.karpisiewicz.mateusz.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@NamedQuery(name = "Contact.findContactsByEmail", query = "select c from Contact c where c.email like :email")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotNull
    @Length(min = 1, max = 40)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Length(min = 1, max = 40)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Length(max = 1)
    @Column(name = "middle_last_name")
    private String middleNameInitial;

    @Email
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getMiddleNameInitial(){
        return  middleNameInitial;
    }

    public void setMiddleNameInitial(String middleInitial){
        this.middleNameInitial = middleInitial;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
