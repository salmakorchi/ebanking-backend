package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
@Data//getters and setters
//constructors
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount extends  BankAccount{
    private double overDraft;

}
