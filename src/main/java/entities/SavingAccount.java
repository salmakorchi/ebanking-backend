package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("SA")
@Data//getters and setters
//constructors
@NoArgsConstructor
@AllArgsConstructor
public class SavingAccount extends BankAccount{
    private double interestRate;
}
