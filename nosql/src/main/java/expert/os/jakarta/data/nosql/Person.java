package expert.os.jakarta.data.nosql;


import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public class Person {


    @Id
    private Long id;


    @Column
    private String name;

}
